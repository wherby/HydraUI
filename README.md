# HydraUI

The repository is based on Play framwork to provide interface for [Hyra Cluster](https://github.com/wherby/Hydra).

## What is this repository for? ##

 The HydraUI will provide interface of create app, [delete app, query cluster nodes status, query apps status,
 and so on ]. However, there is only create app function is implemented now.

* Quick summary
* Version 0.0.1
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

## How do I get set up? ##
Firstly the HydraUI is for Hydra Cluster, you need to setup Hydra cluster first.
Then change config file of "akka.conf" according to your Hydra Cluster:
    1.update "akka.cluster.seed-noods" to any node of Hydra Cluster
    2.update "akka.remote.netty.tcp.hostname" to ip address of host which the project is running.

