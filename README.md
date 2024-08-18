# CodeExplorer

CodeExplorer system will explore legacy code, analyse the relations between task descriptions and changes in commits, extract knowledge from the data, and then provide technical details about the new tasks described in natural language.

CodeExplorer system is a complex tool that create entity relation map between entites in natural language and programme units (files, packages, modules). The aim of the system to provide a brief picture of task in natural language with terms and categories of software development side. This map is based on analysis of task description in task tracking systems and commited programme units related to this task so it applicable only for systems with long history, that can be collected from task tracking and version control systems.

This system contain three mandatory modules: CodeCollector, CodeAnalyser, СodeHelper,  and many pluggins for work with differnet version control, task or bug tracking systems and provide additional data presentation layer or data analyser methods.

    **CodeCollector** - is the system for collect data from version control and task tracker systems. Version control system is a master, so CodeCollector collect commits, try to extract task number from the commit comments and description and then collet task description form task tracking system, and save it as information related to commit.

    **CodeAnalyser** - is the core platform for analyse code and task descriptions. It has embedded tokeniser, do the first naive bayes analyse and provide API for external analysers like LLM or custom model.

    **CodeHelper** - is the core platform for provide access to end user for results of the analyses. It has dashboard, reporting, recomndational system and the chatbot.

## QuickStart
-------------------------
Three core modules of the system writen in Java. We have prebuilded *.war files and also docker file so they can be started with Tomcat server or with docker.
Also we provide docker compose file with all necessary embedded modules like database or TinyLlama, so it can be runed personaly on local machine, on the premises server or in the cloud if your project is big and dynamic.


### Start with Tomcat
-------


### Start with Docker
-------


### Start with Podman
-------


## Continius Integration
If your project is dynamicaly grow and new entites appear regularly, then we recommend to run the analyse periodicaly or each time when you prepare new release.  In this case CodeCollector module can be configured and read commits only for selected date range.

## Plugging Development
