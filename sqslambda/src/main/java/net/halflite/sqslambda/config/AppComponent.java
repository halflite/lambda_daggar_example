package net.halflite.sqslambda.config;

import javax.inject.Singleton;
import dagger.Component;
import net.halflite.sqslambda.service.ProcessingService;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
  public ProcessingService processingService();
}
