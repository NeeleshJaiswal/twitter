package com.twitter.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@PropertySource("classpath:application.properties")
public class TwitterConfiguration {

    @Value( "${twitter.consumer.key}" )
    private String consumerKey;
    @Value( "${twitter.consumer.secret}" )
    private String consumerSecret;
    @Value( "${twitter.accessToken}" )
    private String accessToken;
    @Value( "${twitter.accessTokenSecret}" )
    private String accessTokenSecret;

    ConfigurationBuilder cb;

    @Autowired
    public TwitterConfiguration() {
        this.cb = new ConfigurationBuilder();
    }




    @Bean
    public TwitterFactory getConfiguredTwitterFactory() {
        cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        return new TwitterFactory(cb.build());
    }
}
