package org.adi.springPA;

import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.init;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
public class InMemoryH2Test {

  @Rule
  public ProcessEngineRule rule = new ProcessEngineRule();

  private static final String PROCESS_DEFINITION_KEY = "springPA";

  // enable more detailed logging
  static {
//    LogUtil.readJavaUtilLoggingConfigFromClasspath(); // process engine
//    LogFactory.useJdkLogging(); // MyBatis
  }

  @Before
  public void setup() {
    init(rule.getProcessEngine());
  }

  /**
   * Just tests if the process definition is deployable.
   */
  @Test
  @Deployment(resources = "process.bpmn")
  public void testParsingAndDeployment() {
    // nothing is done here, as we just want to check for exceptions during deployment
  }

/*
  @Test
  @Deployment(resources = { "process.bpmn" })
  public void testAdisSignal() throws InterruptedException {

    final RuntimeService runtimeService = rule.getRuntimeService();
    final TaskService taskService = rule.getTaskService();

    //start the process instance
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("springPA");

    //instanz is running
    assertThat(processInstance).isActive();

    //sende das signal
    runtimeService.signalEventReceived("adisSignal");


    Thread.sleep(30000);

    // the process instance is now waiting in the first wait state (gateway signal or timer):
    Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
    assertThat(task).hasName("User Task");

    // Complete this task. This triggers the synchronous invocation of the
    // service task. This method invocation returns after the service task
    // has been executed and the process instance has advanced to the second waitstate.
    taskService.complete(task.getId());


    // check for variable set by the service task:
    //variables = runtimeService.getVariables(processInstance.getId());
    //assertEquals(SynchronousServiceTask.PRICE, variables.get(SynchronousServiceTask.PRICE_VAR_NAME));

    //instanz is ended
    assertThat(processInstance).isEnded();

  }
*/
}
