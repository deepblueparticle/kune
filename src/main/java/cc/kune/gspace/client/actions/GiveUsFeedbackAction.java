package cc.kune.gspace.client.actions;

import cc.kune.common.client.actions.AbstractExtendedAction;
import cc.kune.common.client.actions.ActionEvent;
import cc.kune.common.client.notify.NotifyLevel;
import cc.kune.common.client.notify.NotifyUser;
import cc.kune.common.client.utils.SimpleResponseCallback;
import cc.kune.core.client.auth.SignIn;
import cc.kune.core.client.rpcservices.AsyncCallbackSimple;
import cc.kune.core.client.rpcservices.ContentServiceAsync;
import cc.kune.core.client.state.Session;
import cc.kune.core.client.state.SiteTokens;
import cc.kune.core.client.state.StateManager;
import cc.kune.core.client.state.TokenUtils;
import cc.kune.core.shared.i18n.I18nTranslationService;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class GiveUsFeedbackAction extends AbstractExtendedAction {

  private final Provider<ContentServiceAsync> contentService;
  private final I18nTranslationService i18n;
  private final Session session;
  private final Provider<SignIn> signIn;
  private final StateManager stateManager;

  @Inject
  public GiveUsFeedbackAction(final Session session, final Provider<SignIn> signIn,
      final StateManager stateManager, final I18nTranslationService i18n,
      final Provider<ContentServiceAsync> contentService) {
    this.session = session;
    this.signIn = signIn;
    this.stateManager = stateManager;
    this.i18n = i18n;
    this.contentService = contentService;
  }

  @Override
  public void actionPerformed(final ActionEvent event) {
    if (session.isLogged()) {
      NotifyUser.askConfirmation(
          i18n.t("Confirm, please:"),
          i18n.t("Do you want to write us with some positive or negative feedback? This can help us to improve these services"),
          new SimpleResponseCallback() {
            @Override
            public void onCancel() {
            }

            @Override
            public void onSuccess() {
              contentService.get().sendFeedback(session.getUserHash(),
                  i18n.t("Feedback of [%s]", session.getCurrentUser().getShortName()),
                  i18n.t("Edit and write here your feedback."), new AsyncCallbackSimple<String>() {
                    @Override
                    public void onSuccess(final String url) {
                      stateManager.gotoHistoryToken(url);
                    }
                  });
            }
          });
    } else {
      signIn.get().setErrorMessage(i18n.t("Sign in or create an account to give us feedback"),
          NotifyLevel.info);
      stateManager.gotoHistoryToken(TokenUtils.addRedirect(SiteTokens.SIGNIN,
          session.getCurrentStateToken().toString()));
    }
  }
}