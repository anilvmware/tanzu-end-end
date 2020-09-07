package com.demo.bookorderservice;


import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.FileDescriptorMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.core.instrument.binder.system.UptimeMetrics;
import io.micrometer.wavefront.WavefrontConfig;
import io.micrometer.wavefront.WavefrontMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Counter;


@Configuration
//@EnableAspectJAutoProxy
class RegistryConfig  {

    public static Counter bookOrderApiCounter;
    static WavefrontConfig config = null;
	static MeterRegistry registry = null;


    @PostConstruct
    public void postInit() {
    	
    	WavefrontConfig config = new WavefrontConfig() {
		    @Override
		    public String uri() {
		        return "https://surf.wavefront.com";
		    }

		    @Override
		    public String apiToken() {
		        return "enter-your-token";
		    }

		    @Override
		    public String get(String key) {
		        return null;
		    }
		    
		};
    	
    	
    	MeterRegistry registry = new WavefrontMeterRegistry(config, Clock.SYSTEM);
    	
    	registry.config().commonTags(
				"app.name", "BookOrder",
				"env", "dev"
				);
    	
    	// default JVM stats
		new ClassLoaderMetrics().bindTo(registry);
		new JvmMemoryMetrics().bindTo(registry);
		
		JvmGcMetrics jvmGcMetrics = new JvmGcMetrics();
		jvmGcMetrics.bindTo(registry);
		
		new ProcessorMetrics().bindTo(registry);
		new JvmThreadMetrics().bindTo(registry);
		new FileDescriptorMetrics().bindTo(registry);
		new UptimeMetrics().bindTo(registry);
    	
		bookOrderApiCounter = Metrics.counter("mybookorder.api.count", "type", "Matilda");
    }
    
    public static MeterRegistry getMeterRegistry() {
		return registry;
	}
}
