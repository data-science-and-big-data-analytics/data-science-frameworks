# Concepts

## In this folder you will find: 
- `concepts_example.py`: A provided example file, which you can execute and inspect
- `concepts_example.ipynb`: A provided Jupyter Notebook, which you can execute and inspect

All other files, which are needed to run the framework, will be downloaded with the commands, stated in the following sections. 



# A. General Information
- Authors
  - Christian Lindig
- Paper: 
  - http://www.st.cs.uni-saarland.de/publications/files/lindig-fca-2000.pdf 
- Code: 
  - https://pypi.org/project/concepts/



# B. Requirements
 - Python
 - Graphviz



# C. Installation
Install the concept library in the Concept-venv virtual python environment: 
```bash
# Inside the /data-science-frameworks/Concepts/ folder
$ virtualenv Concepts-venv
$ source Concepts-venv/bin/activate
$ pip3 install concepts
$ deactivate
```



# D. Data
There already exists the files `concepts_example.py` and `concepts_example.ipynb` within this repository. 



# E. Usage 
Import library: 
```python
>>> from concepts import Context
```

Read concept from a string: 
```python
>>> c = Context.fromstring(...)
```

Dervive the intension and/or extension:
```python
>>> c.intension(...)
>>> c.extension(...)
```

Get the closest object-properties pair: 
```python
>>> c[...]
```

The concept lattice is stored in the lattice attribute: 
```python
>>> c.lattice
```

Visualize the results with graphviz:
```python
>>> c.lattice.graphviz()
```



# E. Example
```bash
# Activate Concepts-venv environment
$ source Concepts-venv/bin/activate

$ python3 concepts_example.py

# Deactivate Concepts-venv environment
$ deactivate
```

You can view the `concept_example.py` file to better understand how the library can be used. 


## Jupyter Notebook
You can also view the code with the jupyter notebook. Make sure to install the jupyterlab in the virtual python environment before (see ReadMe.md of the root directory).
