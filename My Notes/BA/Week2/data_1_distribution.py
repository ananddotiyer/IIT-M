# -*- coding: utf-8 -*-
"""data_1_distribution.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1MLigfo1o2f2zU6GP6F3TFWRaKQUsOuUo
"""

import numpy as np
import pandas as pd

df = pd.read_excel('data_1.xlsx')

df

import matplotlib.pyplot as plt
plt.hist(df['obs'])
plt.show()

df.describe()

stats_labels = ['Mean Observed', 'Variance Observed', 'Skew Observed', 'Kurt Observed']
stats_values = [round(df['obs'].mean(), 2), round(df['obs'].var(), 2), round(df['obs'].skew(),2), round(df['obs'].kurt(),2)]
print(set(zip(stats_labels, stats_values)))

df.median()

import statsmodels.api as sm
import scipy.stats as stats

import matplotlib.pyplot as pltp
stats.probplot(df['obs'], plot=plt)
plt.show()

stats.probplot(df['obs'], dist='poisson', sparams=(4.940000,), plot=plt)
plt.show()

print(df)

grouped_df = pd.DataFrame()

grouped_df['frequency']= df.groupby('obs')['obs'].count()
grouped_df

len(df)

grouped_df['OBS_PROBA'] = grouped_df['frequency']/len(df)
print(grouped_df)

from scipy import stats
from scipy.stats import poisson
from scipy.stats import chisquare

poisson.pmf

grouped_df.index

df['obs'].mean()

grouped_df['POISSON_PMF'] = poisson.pmf(k=grouped_df.index, mu=df['obs'].mean())

df['obs'].mean()

grouped_df['POISSON_PMF']

grouped_df

grouped_df['POISSON_FREQ'] = grouped_df['POISSON_PMF']*len(df)

grouped_df

grouped_df['POISSON_FREQ'] = [round(elem,2) for elem in grouped_df['POISSON_FREQ']]

grouped_df

obs_freq = list(grouped_df['frequency'])
expec_freq = list(grouped_df['POISSON_FREQ'])

"""NULL HYPOTHESIS: The given data follows Poisson distribution.

---


ALTERNATE HYPOTHESIS: The given data does not follow Poisson distribution
"""

obs_freq

expec_freq

stats.chisquare(obs_freq, expec_freq)

import scipy.stats

scipy.stats.chi2.ppf(1-.05, df=9)

