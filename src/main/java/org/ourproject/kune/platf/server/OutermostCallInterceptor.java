/*
 * Copyright (C) 2007 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * Kune is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kune is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.ourproject.kune.platf.server;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.inject.Inject;
import com.google.inject.Injector;

/*
 * See: http://tembrel.blogspot.com/2007/09/matcher-and-methodinterceptor-for-dwr.html
 *
 */

public class OutermostCallInterceptor implements MethodInterceptor {
    /**
     * Decorates a MethodInterceptor so that only the outermost invocation using
     * that interceptor will be intercepted and nested invocations willbe
     * ignored.
     */
    public static MethodInterceptor outermostCall(final MethodInterceptor interceptor) {
        return new OutermostCallInterceptor(interceptor);
    }

    /** Ensure underlying interceptor is injected. */
    @Inject
    void injectInterceptor(final Injector injector) {
        injector.injectMembers(interceptor);
    }

    public Object invoke(final MethodInvocation invocation) throws Throwable {
        int savedCount = (Integer) count.get();
        count.set(savedCount + 1);
        try {
            if ((Integer) count.get() > 1) {
                return invocation.proceed();
            } else {
                return interceptor.invoke(invocation);
            }
        } finally {
            count.set(savedCount);
        }
    }

    private OutermostCallInterceptor(final MethodInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    private final MethodInterceptor interceptor;

    private final ThreadLocal count = new ThreadLocal() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
}