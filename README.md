# Data-Science Frameworks

This git repository explains how to use selected data science frameworks. Furthermore helpful tips and available infrastructure are stated. 

### Frameworks for Text Classification: 
 - Quadflor (Python)
 - FastText (C++11)
 - TextGCN (Python)

### Frameworks for Formal Concept Analysis (FCA): 
 - colibri (Java)
 - concepts (Python)

### Frameworks for Learning to Rank (L2R): 
 - Lemur Project (Java)
 - IRGAN framework (Python)


## Per framework it is documented:

- **A.** **General information** where to find the code and related papers
- **B.** Which **requirements** are needed
- **C.** How to **install** the framework
- **D.** How to **obtain** (example) files
- **E.** Explanation **how to use** the framework (on the example files)
- (**F.** Evaluation or Visualization of the results)




# Tips to Text Preprocessing
Try to start with small datasets! Preprocess special characters as ä,ö,ü,ß,... 
It is often useful to convert all symbols to lowercase. 
There already exists libraries for text preprocessing like the Natural Language Toolkit (NLTK) for Python (https://www.nltk.org/). 



# Facing Different Python Library Versions
When testing different python frameworks you often need different python library versions. They are often not compatible. Therefore it is helpful to create a virtual python environment for one framework: 

```bash
# Install
$ pip3 install virtualenv

# Create virtual environment <framework>
$ cd <framework>
$ virtualenv <framework>-venv

# Activate the virtual environment
$ source <framework>-venv/bin/activate
```

More Information:
 - https://docs.python-guide.org/dev/virtualenvs/



# Jupyter notebooks
There are some jupyter notebooks provided. You have to install the jupyter lab in every virtual python environment if you want to use it for the framework. 

## Installation
```bash
$ source <framework>-venv/bin/activate
$ pip3 install jupyterlab
$ deactivate
```

## Execute
You can start the jupyter server with: 
```bash
$ source <framework>-venv/bin/activate
$ jupyter lab
```

You will get an output, which shows you an url like this one:

http://localhost:8888/?token=72ed45f9087a9159d44003b8cf5673cbb206dee2092e02cc

If you run the jupyter lab on the same machine on which you are working on, you can just open this link in the browser. 

## Remote Jupyter Lab
If you run the jupyter lab on a server and you want to access it from your own machine, you can run a ssh bridge, which forwards the server port: 

```bash
# Run this command on your own machine, after you started the jupyter notebook on the server
$ ssh -N -L 8888:localhost:8888 user@server
```

Now you can open the link stated by the jupyter lab server in your own browser.

# Available Hardware
Most of the work can be done on their own personal computer. But when it comes to larger datasets better hardware is very useful! 


## bwCloud: 
https://www.uni-ulm.de/einrichtungen/kiz/service-katalog/server-data/bwcloud-scope/ 

You are allowed to create one or more virtual servers with fixed given resources at the bwCloud. You are completely self responsible to install, maintain and execute everything on these servers. 
There is no GPU available on these machines! 

More Information: 
 - [First Steps](https://www.bw-cloud.org/de/erste_schritte)
 - [Dashboard](https://portal.bw-cloud.org/auth/login/?next=/)


## bwUniCluster
https://www.uni-ulm.de/einrichtungen/kiz/service-katalog/high-performance-computing/bwunicluster-20/

You have the possibility to run jobs on the bwUniCluster. There are GPUs provided. In contrast to bwCloud you don't have any administrative rights. If there is any missing software you will probably face some problems. 
But you can install python libraries with 

```bash
$ pip3 install --user <library>
```

if 

```bash
$ pip3 install <library>
```

doesn't work.

### Access
For the bwUniCluster **VPN** and a **2FactorAuth** is absolutely necessary. You can use 
`ssh ul_USERNAME@uc2.scc.kit.edu` to connect to the login node of the cluster. 

You can submit a job by creating a file `job.sh`: 
```bash
#!/bin/sh
#SBATCH --ntasks=1
#SBATCH --time=00:01:00
#SBATCH --gres=gpu:1
#SBATCH --mail-type=ALL
#SBATCH --mail-user=surname.name@uni-ulm.de
python3 test.py > out.txt
```

and then run 
```bash
$ sbatch -p gpu_4 job.sh
```
[--> Information to Batch Queues](https://wiki.bwhpc.de/e/BwUniCluster_2.0_Batch_Queues)


### Jupyter Lab Interface 
Recently there also exists a Jupyter Lab interface. A documentation is given at: https://wiki.bwhpc.de/e/Jupyter_at_SCC

**VPN** and a **2FactorAuth** is again absolutely necessary. Besides these restricitions it is convienient to get access to the cluster by the Jupyter Lab interface. 

### More information: 
 - [Hardware and Architecture](https://wiki.bwhpc.de/e/BwUniCluster_2.0_Hardware_and_Architecture)
 - [BwUniCluster_2 Wiki](https://wiki.bwhpc.de/e/Category:BwUniCluster_2.0)


## Google Colab
- https://colab.research.google.com

Google Colab is a from Google provided platform, which provides GPU ressources. 
Its only use case are **Python Jupyter Notebooks**!
You can easily share one notebook with your team mates and work together. 

You also can install additional libraries, if needed:

```[ ] !pip install matplotlib-venn```



## SSH Key
You often need a SSH Key to be able to connect to the servers. A SSH Key consists of two parts: a public one (often called id_rsa.pub) and a private one (often called id_rsa). Never ever upload or publish your private key! Linux provides several helpful commands to create your SSH Key and copy your public key to the server (https://www.ssh.com/ssh/keygen/): 
 - ssh-keygen -t rsa 
 - ssh-copy-id user@host

Sometimes you can or you need to upload your public key (id_rsa.pub) via the webpage interface of the service (e.g. github, gitlab,...). 

In Windows and Mac it is often a lot easier to use the linux commands. E.g. use the linux subsystem on windows to create and copy the keys and then copy them to C:/Users/\<user>/.ssh/ with 

```bash
$ cp ~/.ssh/* /mnt/c/Users/\<user>/.ssh/
```


## Copy Files to the Server
You can use scp to copy files to the server. If you prefer a UI you can also use FileZilla (https://filezilla-project.org/). 

You should always download large datasets directly to the server with the `wget` or `curl` (or a similar) command if possible. Also consider creating Makefiles to simplify repetitive tasks (e.g. for downloading several files multiple times). 

# Different Distributions
All frameworks are tested with Ubuntu 20.04 LTS distribution. 

## Windows 
You can probably run all the frameworks also inside the Linux Subsystem on Windows.

## Mac
You can probably also get most of the frameworks work in the provided terminal on Mac.

## bwCloud
You can always install and use Linux (e.g. Ubuntu 20.04 LTS) on the **bwCloud**. 

Bookmark this link: https://github.com/data-science-and-big-data-analytics/data-science-frameworks


