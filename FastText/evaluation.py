#!/usr/bin/env python3

import sys
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.decomposition import PCA


NUMBER_OF_WORDS = 50

file_path = sys.argv[1]

lines = pd.read_table(file_path, header=None, delim_whitespace=True)
lines = lines.sample(NUMBER_OF_WORDS).reset_index(drop=True)
words = lines.iloc[:, 0]
vectors = lines.iloc[:, 1:]

pca = PCA(n_components=2)
vecs_transformed = pca.fit_transform(vectors)

plt.figure(figsize=(16, 16))
for i in range(len(words)):
    (x, y) = [float(val) for val in vecs_transformed[i]]
    plt.scatter(x, y)
    plt.annotate(words[i],
                 xy=(x, y),
                 xytext=(5, 2),
                 textcoords='offset points',
                 ha='right',
                 va='bottom')

plt.show()
plt.savefig('evaluation.png')
