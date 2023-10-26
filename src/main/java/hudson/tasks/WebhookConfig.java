package hudson.tasks;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import hudson.util.Secret;

public final class WebhookConfig extends AbstractDescribableImpl<WebhookConfig> {
  private String label;
  private String url;
  private Secret bearerToken;

  @DataBoundConstructor
  public WebhookConfig(String label, String url, Secret bearerToken) {
    this.label = label;
    this.url = url;
    this.bearerToken = bearerToken;
  }

  public String getLabel() {
    return label;
  }

  public String getUrl() {
    return url;
  }

  public Secret getBearerToken() {
    return bearerToken;
  }

  @Extension
  public static class DescriptorImpl extends Descriptor<WebhookConfig> {
    @Override
    public String getDisplayName() {
      return "Webhook config";
    }
  }
}
