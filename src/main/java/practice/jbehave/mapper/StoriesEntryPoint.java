package practice.jbehave.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import practice.jbehave.steps.LoginFacebookSteps;
import practice.jbehave.steps.VisitWikipediaSteps;

public class StoriesEntryPoint extends JUnitStories {

	public StoriesEntryPoint() {
		super();
		List<CandidateSteps> steps = new ArrayList<CandidateSteps>();
		steps.add(new VisitWikipediaSteps());
		steps.add(new LoginFacebookSteps());
		this.configuredEmbedder().candidateSteps().addAll(steps);
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader()))
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withFormats(Format.CONSOLE, Format.STATS, Format.HTML));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("practice/jbehave/stories/VisitWikipediaAcceptanceTestCriteria.story",
				"practice/jbehave/stories/LoginFacebookATC.story");

	}

}
