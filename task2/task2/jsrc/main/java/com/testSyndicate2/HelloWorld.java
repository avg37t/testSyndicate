package com.testSyndicate2;

import java.util.LinkedHashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.syndicate.deployment.annotations.lambda.LambdaHandler;
import com.syndicate.deployment.annotations.lambda.LambdaUrlConfig;
import com.syndicate.deployment.model.RetentionSetting;
import com.syndicate.deployment.model.lambda.url.AuthType;

@LambdaHandler(lambdaName = "hello_world",
        roleName = "hello_world-role",
//        isPublishVersion = false,
//        aliasName = "${lambdas_alias_name}",
        logsExpiration = RetentionSetting.SYNDICATE_ALIASES_SPECIFIED
)
@LambdaUrlConfig(authType = AuthType.NONE)
public class HelloWorld implements RequestHandler<Object, Map<String, Object>> {

    public Map<String, Object> handleRequest(Object request, Context context) {
        System.out.println("Hello from lambda");
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("statusCode", 200);
        resultMap.put("message", "Hello from Lambda");
        return resultMap;
    }
}
