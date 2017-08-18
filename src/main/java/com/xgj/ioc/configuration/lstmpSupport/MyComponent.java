package com.xgj.ioc.configuration.lstmpSupport;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

	private List<Plugin> plugins;

	private Map<String, Plugin> pluginMap;

	// Spring会将容器中所有类型为Plugin的Bean注入到这个变量中
	@Autowired(required = false)
	public void setPlugins(List<Plugin> plugins) {
		this.plugins = plugins;
	}

	// 将Plugin类型的Bean注入到Map中
	@Autowired
	public void setPluginMap(Map<String, Plugin> pluginMap) {
		this.pluginMap = pluginMap;
	}

	/**
	 * 
	 * 
	 * @Title: getPlugins
	 * 
	 * @Description: 获取Plugins
	 * 
	 * @return
	 * 
	 * @return: List<Plugin>
	 */
	public List<Plugin> getPlugins() {
		return plugins;
	}

	/**
	 * 
	 * 
	 * @Title: getPluginMap
	 * 
	 * @Description: 获取Map
	 * 
	 * @return
	 * 
	 * @return: Map<String,Plugin>
	 */
	public Map<String, Plugin> getPluginMap() {
		return pluginMap;
	}

}
