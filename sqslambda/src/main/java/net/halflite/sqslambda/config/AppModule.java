package net.halflite.sqslambda.config;

import javax.inject.Singleton;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
  /** logger */
  private final static Logger LOG = LoggerFactory.getLogger(AppModule.class);

  @Provides
  @Singleton
  public Config config() {
    return ConfigProvider.getConfig();
  }
  
  @Provides
  @Singleton
  public ObjectMapper objectMapper() {
    // snake_case JSON Mapper
    return new ObjectMapper()
        .setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
  }

  @Provides
  @Singleton
  public AWSCredentialsProvider credentialsProvider(Config config) {
    String accessKey = config.getValue("aws.access.key.id", String.class);
    String secretKey = config.getValue("aws.secret.access.key", String.class);
    LOG.debug("aws.access.key:{}, aws.secret.key:{}", accessKey , secretKey );
    AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
    return new AWSStaticCredentialsProvider(credentials);
  }
}
