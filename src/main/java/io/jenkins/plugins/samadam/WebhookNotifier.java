package io.jenkins.plugins.samadam;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.tasks.Notifier;
import hudson.tasks.WebhookConfig;
import jenkins.tasks.SimpleBuildStep;

public class WebhookNotifier extends Notifier implements SimpleBuildStep {
  private final WebhookConfig webhookConfig;

  @DataBoundConstructor
  public WebhookNotifier(WebhookConfig webhookConfig) {
    this.webhookConfig = webhookConfig;
  }
}
