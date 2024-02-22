package com.wsp.config;

import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/src/test/resources/config/config.properties")
public interface FrameworkConfig extends Config {

    int timeout();
    String url();
    String browser();

}
