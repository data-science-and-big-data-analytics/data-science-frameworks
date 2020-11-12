# IRGAN
All files, which are needed to run the framework, will be downloaded with the commands, stated in the following sections. 



# A. General Information
- Authors:
  - Jun Wang, Lantao Yu, Weinan Zhang, Yu Gong, Yinghui Xu, Benyou Wang, Peng Zhang, Dell Zhang
- Paper: 
  - https://arxiv.org/pdf/1705.10513.pdf
- Code: 
  - https://github.com/iYiYaHa/PyTorch-IRGAN



# B. Requirements
- Git
- Python (Anaconda)



# C. Installation
To install IRGAN we need [Anaconda](https://www.anaconda.com/), which is more powerful, but also more complex than virtualenv. Check the webpage of anaconda for the newest verson. We will install version 2020.07 here:

```bash
$ wget https://repo.anaconda.com/archive/Anaconda3-2020.07-Linux-x86_64.sh
$ chmod +x Anaconda3-2020.07-Linux-x86_64.sh
$ ./Anaconda3-2020.07-Linux-x86_64.sh
# Follow installation guide and wait
$ rm Anaconda3-2020.07-Linux-x86_64.sh
$ source ~/.bashrc
```

After Anaconda is installed we can install IRGAN:
```bash
# Inside the /data-science-frameworks/IRGAN/ folder
$ git clone https://github.com/iYiYaHa/PyTorch-IRGAN.git
$ sed -i 's/pytorch.*$/pytorch/g' PyTorch-IRGAN/requirements.txt
$ sed -i 's/torchvision.*$/torchvision/g' PyTorch-IRGAN/requirements.txt
$ conda create --name IRGAN-venv --file PyTorch-IRGAN/requirements.txt
```



# D. Data
Example data is already provided within the IRGAN framework



# E. Usage Example
```bash
$ conda activate IRGAN-venv
$ cd PyTorch-IRGAN/
$ jupyter notebook
# Work with the 'IRGAN-SGD-dns-gen.ipynb' Jupyter Notebook

# End Jupyter Notebook with Ctrl + c 

# Deactivete conda environment with
$ conda deactivate
```


## Without GPU
If you don't have a GPU on your server you probably want to try the implementation with the cpu. 
Therefore you have to adapt the `config.py` file: 

```python
### Replace the number of epochs to a very low number. Try '1' to get a feeling of how long it will take. 
7: self.epochs = 1

### Replace "cuda:0" with "cpu"
19: self.device = "cuda:0"

### Replace "cuda:0" with "cpu"
28: self.device = "cuda:0"
```

In short: You should adapt the number of epochs and replace `"cuda:0"` with `"cpu"`. 
