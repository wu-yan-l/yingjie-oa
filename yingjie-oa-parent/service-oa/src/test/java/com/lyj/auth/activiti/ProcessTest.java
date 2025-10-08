package com.lyj.auth.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProcessTest {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;

    @Test
    public void SingleSuspendProcessInstance() {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId("358f74af-9a15-11f0-a56f-e4fd453d6ca7").singleResult();
        boolean suspended = processInstance.isSuspended();
        if (suspended) {
            runtimeService.activateProcessInstanceById(processInstance.getId());
            System.out.println(processInstance.getId() + "激活");
        } else {
            runtimeService.suspendProcessInstanceById(processInstance.getId());
            System.out.println(processInstance.getId() + "挂起");
        }
    }

    @Test
    public void suspendProcessInstanceAll() {
        ProcessDefinition qingjia = repositoryService.createProcessDefinitionQuery().processDefinitionKey("qingjia").singleResult();
        boolean suspended = qingjia.isSuspended();
        if (suspended) {
            repositoryService.activateProcessDefinitionById(qingjia.getId(), true, null);
            System.out.println("流程定义:" + qingjia.getId() + "激活");
        } else {
            repositoryService.suspendProcessDefinitionById(qingjia.getId(), true, null);
            System.out.println("流程定义:" + qingjia.getId() + "挂起");
        }
    }

    @Test
    public void startUpProcessAddBusinessKey() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("qingjia", "1001");
        System.out.println("业务" + processInstance.getBusinessKey());
    }

    @Test
    public void findCompleteTask() {
        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
                .taskAssignee("lisi ").finished().list();
        for (HistoricTaskInstance historicTaskInstance : list) {
            System.out.println("流程实例id：" + historicTaskInstance.getProcessInstanceId());
            System.out.println("任务id：" + historicTaskInstance.getId());
            System.out.println("任务负责人：" + historicTaskInstance.getAssignee());
            System.out.println("任务名称：" + historicTaskInstance.getName());
        }
    }

    @Test
    public void completeTask() {
        Task task = taskService.createTaskQuery()
                .taskAssignee("zhangsan").singleResult();
        taskService.complete(task.getId());
    }

    @Test
    public void findTaskList() {
        String assignee = "zhangsan";
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee(assignee).list();
        for (Task task : list) {
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }

    @Test
    public void startProcess() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("qingjia");
        System.out.println("流程定义id" + processInstance.getProcessDefinitionId());
        System.out.println("流程实例id" + processInstance.getId());
        System.out.println("活动id" + processInstance.getActivityId());
    }

    @Test
    public void deployProcess() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("process/qingjia.bpmn20.xml")
                .addClasspathResource("process/qingjia.png")
                .name("请假申请流程")
                .deploy();
        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }
}
