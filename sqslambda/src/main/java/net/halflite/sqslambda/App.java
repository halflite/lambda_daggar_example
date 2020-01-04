package net.halflite.sqslambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

public class App implements RequestHandler<SQSEvent, Void> {
  /** logger */
  private static final Logger LOG = LoggerFactory.getLogger(App.class);

  @Override
  public Void handleRequest(SQSEvent event, Context context) {
    LOG.info("start.");
    return null;
  }
}
