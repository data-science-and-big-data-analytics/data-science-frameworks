# Lemur

## In this folder you will find: 
- `RankLib.jar`: For convienence, the current newest version (2.14) of RankLib from the Lemur project is already contained in this repository
- `MQ2008.tar.bz`: Provided example data

For this framework you don't have to download anything. But you can find all the ressources online, too. 



# A. General Information
- Paper: 
  - [1] C.J.C. Burges, T. Shaked, E. Renshaw, A. Lazier, M. Deeds, N. Hamilton and G. Hullender. Learning to rank using gradient descent. In Proc. of ICML, pages 89-96, 2005.
  - [2] Y. Freund, R. Iyer, R. Schapire, and Y. Singer. An efficient boosting algorithm for combining preferences. The Journal of Machine Learning Research, 4: 933-969, 2003.
  - [3] J. Xu and H. Li. AdaRank: a boosting algorithm for information retrieval. In Proc. of SIGIR, pages 391-398, 2007.
  - [4] D. Metzler and W.B. Croft. Linear feature-based models for information retrieval. Information Retrieval, 10(3): 257-274, 2007.
  - [5] Q. Wu, C.J.C. Burges, K. Svore and J. Gao. Adapting Boosting for Information Retrieval Measures. Journal of Information Retrieval, 2007.
  - [6] J.H. Friedman. Greedy function approximation: A gradient boosting machine. Technical Report, IMS Reitz Lecture, Stanford, 1999; see also Annals of Statistics, 2001.
  - [7] Z. Cao, T. Qin, T.Y. Liu, M. Tsai and H. Li. Learning to Rank: From Pairwise Approach to Listwise Approach. ICML 2007.
  - [8] L. Breiman. Random Forests. Machine Learning 45 (1): 5–32, 2001.
- Code: 
  - https://sourceforge.net/projects/lemur/files/lemur/
- Wiki:
  - https://sourceforge.net/p/lemur/wiki/RankLib/
  - [How to Use - Wiki](https://sourceforge.net/p/lemur/wiki/RankLib%20How%20to%20use/)



# B. Requirements
 - Java



# C. Installation
This repository already contains the current newest version (2.14) of `RankLib.jar`. You can also download `RankLib.jar` from https://sourceforge.net/projects/lemur/files/lemur/. 



# D. Data
There is already the `MQ2008` dataset from [LETOR](http://research.microsoft.com/en-us/um/beijing/projects/letor/letor4dataset.aspx) as a bzip2 compressed file (`'MQ2008.tar.bz'`) given. To unpack it use the following command: 

```bash
# Inside the /data-science-frameworks/Lemur/ folder
$ tar -xjvf MQ2008.tar.bz
```

You can also download other datasets of LETOR from the follwing OneDrive link: https://1drv.ms/f/s!Aqi9ONgj3OqPaynoZZSZVfHPJd0



# E. Usage Example
We will state some examples on how to use the framework: 

## Training on held-out data
We can train our model with the train/test/validation dataset and save it to `mymodel.txt`. 

```bash
$ java -jar RankLib.jar -train MQ2008/Fold1/train.txt -test MQ2008/Fold1/test.txt -validate MQ2008/Fold1/vali.txt -ranker 6 -metric2t NDCG@10 -metric2T ERR@10 -save mymodel.txt
```


## k-fold cross validation
Often we only have the training dataset given. Therefore we can restrict ourself to the train dataset and do a k-fold cross validation. 

### Sequential partition
```bash
$ java -jar RankLib.jar -train MQ2008/Fold1/train.txt -ranker 4 -kcv 5 -kcvmd models/ -kcvmn ca -metric2t NDCG@10 -metric2T ERR@10
```

### Randomized partition
```bash
$ java -cp RankLib.jar ciir.umass.edu.features.FeatureManager -input MQ2008/Fold1/train.txt -output mydata/ -shuffle
```


### Obtain the data used in each fold
We can obtain the used data in each fold with the following command: 

```bash
$ java -cp bin/RankLib.jar ciir.umass.edu.features.FeatureManager -input MQ2008/Fold1/train.txt.shuffled -output mydata/ -k 5
```


### Manpage of the FeatureManager
Further information of the FeatureManager is given with: 
```bash
$ java -cp bin/RankLib.jar ciir.umass.edu.features.FeatureManager
```


## F. Evaluating previously trained models
We can evaluate our model on the test dataset with: 
```bash
$ java -jar bin/RankLib.jar -load mymodel.txt -test MQ2008/Fold1/test.txt -metric2T ERR@10 
```
