package com.webreach.mirth.server.util;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.mozilla.javascript.Scriptable;

import com.webreach.mirth.model.MessageObject;

public class JavaScriptScopeFactory {
	// MessageObject builder
	public void buildScope(Scriptable scope, MessageObject messageObject) {
		buildScope(scope, messageObject.getChannelId());
		scope.put("messageObject", scope, messageObject);
		scope.put("message", scope, messageObject.getTransformedData());
		scope.put("connectorMap", scope, messageObject.getVariableMap());
		scope.put("channelMap", scope, messageObject.getChannelMap());
		scope.put("responseMap", scope, messageObject.getResponseMap());
		scope.put("connector", scope, messageObject.getConnectorName());
	}

	// Generic and Channel Builder
	public void buildScope(Scriptable scope, String channelId) {
		scope.put("alert", scope, new AlertSender(channelId));
		scope.put("router", scope, new VMRouter());
		scope.put("response", scope, new ResponseFactory());
		scope.put("globalMap", scope, GlobalVariableStore.getInstance());
	}

	// Logger builders
	public void buildScope(Scriptable scope, Log scriptLogger) {
		scope.put("logger", scope, scriptLogger);
	}

	public void buildScope(Scriptable scope, Logger scriptLogger) {
		scope.put("logger", scope, scriptLogger);
	}

	// Composite scopes
	public void buildScope(Scriptable scope, MessageObject messageObject, Log scriptLogger) {
		buildScope(scope, messageObject);
		buildScope(scope, scriptLogger);
	}

	public void buildScope(Scriptable scope, MessageObject messageObject, Logger scriptLogger) {
		buildScope(scope, messageObject);
		buildScope(scope, scriptLogger);
	}

	public void buildScope(Scriptable scope, String channelId, Log scriptLogger) {
		buildScope(scope, channelId);
		buildScope(scope, scriptLogger);
	}

	public void buildScope(Scriptable scope, String channelId, Logger scriptLogger) {
		buildScope(scope, channelId);
		buildScope(scope, scriptLogger);
	}
}
