# Quadflor

- Paper: 
  - https://arxiv.org/pdf/1801.06717.pdf
- Code: 
  - https://github.com/florianmai/Quadflor



# Requirements
- Git
- Python 3.7
- libatlas-base-dev, gfortran , and build-essential

Perhaps you have to add the following repo to be able to install Python3.7:
```bash
$ sudo add-apt-repository ppa:deadsnakes/ppa
```



# Installation
```bash
# Inside the /data-science-frameworks/Quadflor/ folder
$ git clone https://github.com/florianmai/Quadflor.git
$ cd Quadflor/
$ git checkout course
$ virtualenv --python=python3.7 lucid_ml_environment
$ source lucid_ml_environment/bin/activate
$ cd Code/
$ sed -i 's/networkx==2.1/networkx==2.2/g' requirements.txt
$ sed -i 's/decorator==4.2.1/decorator==4.3/g' requirements.txt
$ pip3 install -r requirements.txt
$ cd ../../
```



# Get Pretrained Embeddings Data:
```bash
# Inside the /data-science-frameworks/Quadflor/ folder
$ cd Quadflor/Resources/
$ chmod +x get_glove.sh
$ ./get_glove.
$ cd ../../
```



# Get Example Dataset: 
Download the [econbiz.csv and pubmed.csv](https://www.kaggle.com/hsrobo/titlebased-semantic-subject-indexing) files and copy them to the folder `Resources/` .

Or take a small excerpt of the above stated dataset: 
```bash
# Inside the /data-science-frameworks/Quadflor/ folder
$ tar -xjvf econbiz.csv.tar.bz
$ tar -xjvf pubmed.csv.tar.bz
$ mv econbiz.csv pubmed.csv Quadflor/Resources/
```



# Usage Example
```bash
# Inside the /data-science-frameworks/Quadflor/ folder
$ cd Quadflor/
$ source lucid_ml_environment/bin/activate
$ cd Code/lucid_ml/
$ mkdir tmp/
$ python run.py -f mlpsoph -t -k file_paths.json --fixed_folds --folds=1 -v --batch_size=2000 -e 2 --val-size=0.2 --patience=10 --tf-model-path=tmp --max_features=25000 --num_steps_before_validation=2000 --learning_rate=0.001 --dropout=0.5 --memory=0.3 -C ../../Experiments/final_mlp_experiments.cfg -o final_mlp.csv --embedding_size=0 --ngram_limit=2 --optimize_threshold 
```
