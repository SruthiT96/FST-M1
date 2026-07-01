package testRunners;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("feature")
@ConfigurationParameter(
  key = Constants.GLUE_PROPERTY_NAME, value = "stepDefinitions"
)
@ConfigurationParameter(
  key = Constants.FILTER_TAGS_PROPERTY_NAME, 
//	value="@activity1"
//	value="@activity2"
//	value="@activity3"
//	value="@activity4"
//	value="@activity5"
	value="@activity6"
)

public class TestRunner {}
