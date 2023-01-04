package ${package}.android;

import com.testsigma.sdk.Hook;
import com.testsigma.sdk.HookType;
import com.testsigma.sdk.Result;
import com.testsigma.sdk.annotation.Email;
import com.testsigma.sdk.annotation.TestData;
import com.testsigma.sdk.annotation.RunResult;
import com.testsigma.sdk.annotation.TestPlanHook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@TestPlanHook(name="This is my key {EMAIL_ID}", type = HookType.AFTER)
public class ExamplePostPlanHook extends Hook {
    @TestData(reference = "{EMAIL ID}")
    private com.testsigma.sdk.TestData apiKey;
    @TestData(reference = "{SECRET}")
    private com.testsigma.sdk.TestData secret;


    @Email
    com.testsigma.sdk.Email email;

    @RunResult
    private com.testsigma.sdk.RunResult runResult;

    @Override
    protected Result execute() {
        try{
            logger.debug("From addon: SUCCESS, " + apiKey.getValue());
            logger.debug("From addon: SUCCESS, " + secret.getValue());
            logger.debug("From addon: SUCCESS, " + runResult.toString());
            setSuccessMessage("SUCCESS");
            return Result.SUCCESS;
        } catch(Exception e){
            logger.debug("FROM ADDON : ERROR, " + e.getStackTrace().toString());
            setErrorMessage("FAILURE");
            return Result.FAILURE;
        }
    }
}