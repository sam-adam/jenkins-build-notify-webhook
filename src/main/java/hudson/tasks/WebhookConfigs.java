package hudson.tasks;

import java.util.ArrayList;
import java.util.List;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.QueryParameter;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;

@Extension
public final class WebhookConfigs extends AbstractDescribableImpl<WebhookConfigs> {
  private List<WebhookConfig> webhookConfigs;

  @DataBoundConstructor
  public WebhookConfigs() {
    this.webhookConfigs = new ArrayList<>();
  }

  public List<WebhookConfig> getWebhookConfigs() {
    return webhookConfigs;
  }

  @DataBoundSetter
  public void setWebhookConfigs(List<WebhookConfig> webhookConfigs) {
    this.webhookConfigs = webhookConfigs;
  }

  @Extension
  public static class DescriptorImpl extends Descriptor<WebhookConfigs> {
    @Override
    public String getDisplayName() {
      return "Webhook configs";
    }
  }

  // Method to handle webhook deletion
  public void doDeleteWebhook(@QueryParameter("index") int index) {
    if (webhookConfigs != null && index >= 0 && index < webhookConfigs.size()) {
      webhookConfigs.remove(index);
    }
  }
}
