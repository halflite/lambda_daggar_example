package net.halflite.sqslambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import net.halflite.sqslambda.config.*;

public class App implements RequestHandler<SQSEvent, Void> {
  /** logger */
  private static final Logger LOG = LoggerFactory.getLogger(App.class);

  private final AppComponent appComponent;
  
  public App() {
    this.appComponent = DaggerAppComponent.create();
  }

  @Override
  public Void handleRequest(SQSEvent event, Context context) {
    LOG.info("start.");
    appComponent.processingService().execute(event);
    return null;
  }
}
