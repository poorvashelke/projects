<?php
//equations generated by WEKA machine learning linear regression classifier to detect drift
//this data is generated by weka using hrecos dataset
//mae is actually using root mean squared error
$drift_details = [
"temp"=>
    "Temp = -1.87 * DOmg/L + 30.67
    Predicting 0 if attribute value is missing.
    Correlation coefficient                  0.6757
    Mean absolute error                      4.6943
    Root mean squared error                  6.9128
    Relative absolute error                  56.332  %
    Root relative squared error              73.7218 %
    Total Number of Instances                105078     
    Ignored Class Unknown Instances          121",
"ph"=>
    "pH = 0.02 * Dopct + 6.18
    Predicting 0 if attribute value is missing.
    Correlation coefficient                  0.5524
    Mean absolute error                      0.1825
    Root mean squared error                  0.3559
    Relative absolute error                  85.3161 %
    Root relative squared error              83.3566 %
    Total Number of Instances                98174     
    Ignored Class Unknown Instances          7025  ",
"phmv"=>
    "phmv = (-400/7)ph + 400
    Predicting 0 if attribute value is missing.
    Accepted error rate: 10%
    This is a literal relationship.",
"cond"=>
    "Cond = 0.25 * temp + 6.84
    Predicting 0 if attribute value is missing.
    Correlation coefficient                  0.4624
    Mean absolute error                      3.661 
    Root mean squared error                  4.5455
    Relative absolute error                  86.0139 %
    Root relative squared error              88.6675 %
    Total Number of Instances                100337     
    Ignored Class Unknown Instances          4862",
"dopct"=>
    "DO % = 2.02 * DOmg/L + 67.44
    Predicting 0 if attribute value is missing.
    Correlation coefficient                  0.4463
    Mean absolute error                      7.9748
    Root mean squared error                  13.6297
    Relative absolute error                  74.1407 %
    Root relative squared error              89.487  %
    Total Number of Instances                105078     
    Ignored Class Unknown Instances          121",
"domgl"=>
    "DO mg/L = -0.24 * temp + 12.42
    Predicting 0 if attribute value is missing.
    Correlation coefficient                  0.6774
    Mean absolute error                      1.0161
    Root mean squared error                  2.494 
    Relative absolute error                  43.6733 %
    Root relative squared error              73.5632 %
    Total Number of Instances                105077     
    Ignored Class Unknown Instances          122",
"dogain"=>
    "no good data",
"turb"=>
    "Turbidity = -2.22 * cond + 55.11
    Predicting 36.47 if attribute value is missing.
    Correlation coefficient                  0.2191
    Mean absolute error                      18.6056
    Root mean squared error                  49.5892
    Relative absolute error                  87.1234 %
    Root relative squared error              97.5686 %
    Total Number of Instances                105078     
    Ignored Class Unknown Instances          121",
"depth"=>
    "this is in meters
    
    Depth = -0.02 * Dopct + 3.66
    Predicting 6.84 if attribute value is missing.
    Correlation coefficient                  0.1391
    Mean absolute error                      0.7871
    Root mean squared error                  2.0753
    Relative absolute error                  103.3047 %
    Root relative squared error              99.0273 %
    Total Number of Instances                105197     
    Ignored Class Unknown Instances          2"
];

$drift_variables = [
"temp"=> [
    "coeff"=>-1.87,
    "x"=>"domgl",
    "yi"=>30.67,
    "miss"=>0,
    "mae"=>6.9128
],
"ph"=> [
    "coeff"=>0.02,
    "x"=>"dopct",
    "yi"=>6.18,
    "miss"=>0,
    "mae"=>0.3559
],
"phmv"=>[
    "coeff"=>(-400/7),
    "x"=>"ph",
    "yi"=>400,
    "miss"=>0,
    "mae"=>80
],
"cond"=>[
    "coeff"=>0.25,
    "x"=>"temp",
    "yi"=>6.84,
    "miss"=>0,
    "mae"=>4.5455
],
"dopct"=>[
    "coeff"=>2.02,
    "x"=>"domgl",
    "yi"=>67.44,
    "miss"=>0,
    "mae"=>13.6297
],
"domgl"=>[
    "coeff"=>-0.24,
    "x"=>"temp",
    "yi"=>12.42,
    "miss"=>0,
    "mae"=>2.494
],
"dogain"=>[
    "coeff"=>NULL,
    "x"=>NULL,
    "yi"=>NULL,
    "miss"=>NULL,
    "mae"=>NULL
],
"turb"=>[
    "coeff"=>-2.22,
    "x"=>"cond",
    "yi"=>55.11,
    "miss"=>36.47,
    "mae"=>49.5892
],
"depth"=>[
    "coeff"=>NULL,
    "x"=>NULL,
    "yi"=>NULL,
    "miss"=>NULL,
    "mae"=>NULL
]
];


//this is data generated by weka using the ada dataset, poor quality
/*
currently temp/domgl represents a reciprocal audit, this should be fixed when temp is audited on the indepented temp sensor
*/
/*$drift_details = ["temp"=>
    "Temp = -1.22 * DOmgl + 26.66
    Predicting 22.51 if attribute value is missing.
    Correlation coefficient                  0.7167
    Mean absolute error                      2.6119
    Root mean squared error                  3.372 
    Relative absolute error                  64.8949 %
    Root relative squared error              69.7304 %
    Total Number of Instances                11591     
    Ignored Class Unknown Instances          5",
"ph"=>
    "pH = 0.13 * DOmgl + 6.69
    Predicting 6.89 if attribute value is missing.
    Correlation coefficient                  0.6671
    Mean absolute error                      0.3198
    Root mean squared error                  0.4626
    Relative absolute error                  67.2918 %
    Root relative squared error              74.4885 %
    Total Number of Instances                11595     
    Ignored Class Unknown Instances          1 ",
"phmv"=>
    "pHmv = -3.28 * Temp + 30.73
    Predicting -68.55 if attribute value is missing.
    Correlation coefficient                  0.5081
    Mean absolute error                      22.5244
    Root mean squared error                  26.7734
    Relative absolute error                  86.0909 %
    Root relative squared error              86.1213 %
    Total Number of Instances                11595     
    Ignored Class Unknown Instances          1 ",
"cond"=>
    "Cond = 0.01 * DOmgl + 0.7
    Predicting 1.03 if attribute value is missing.
    Correlation coefficient                  0.5248
    Mean absolute error                      0.1408
    Root mean squared error                  0.1807
    Relative absolute error                  83.4555 %
    Root relative squared error              85.1176 %
    Total Number of Instances                11586
    Ignored Class Unknown Instances          10",
"dopct"=>
    "DOpct = 28.54 * pH - 150.64
    Predicting 92 if attribute value is missing.
    Correlation coefficient                  0.5902
    Mean absolute error                      16.6455
    Root mean squared error                  21.7414
    Relative absolute error                  71.1853 %
    Root relative squared error              80.7153 %
    Total Number of Instances                8870     
    Ignored Class Unknown Instances          2726",
"domgl"=>
    "DOmgl = -0.41 * Temp + 13.85
    Predicting 6.8 if attribute value is missing.
    Correlation coefficient                  0.7047
    Mean absolute error                      1.6658
    Root mean squared error                  2.1121
    Relative absolute error                  64.8025 %
    Root relative squared error              70.9461 %
    Total Number of Instances                8992     
    Ignored Class Unknown Instances          2604",
"dogain"=>
    "DOgain does not have any valid values to work with",
"turb"=>
    "Turb = -7.15 * pH + 60.23
    Predicting 0.4 if attribute value is missing.
    Correlation coefficient                  0.2695
    Mean absolute error                      6.1908
    Root mean squared error                  15.8167
    Relative absolute error                  80.0037 %
    Root relative squared error              96.296  %
    Total Number of Instances                11581
    Ignored Class Unknown Instances          15",
"depth"=>
    "Depth is indepedent of other variables"
];
$drift_variables = [
    "temp"=> [
        "coeff"=>0.13,
        "x"=>"domgl",
        "yi"=>6.69,
        "miss"=>6.89,
        "mae"=>0.3198
    ],
    "ph"=> [
        "coeff"=>-0.08,
        "x"=>"temp",
        "yi"=>9,
        "miss"=>4.93,
        "mae"=>0.3295
    ],
    "phmv"=> [
        "coeff"=>-3.28,
        "x"=>"temp",
        "yi"=>30.73,
        "miss"=>-68.55,
        "mae"=>22.5244
    ],
    "cond"=> [
        "coeff"=>0.01,
        "x"=>"domgl",
        "yi"=>0.7,
        "miss"=>1.03,
        "mae"=>0.1408
    ],
    "dopct" => [
        "coeff"=>28.54,
        "x"=>"ph",
        "yi"=>-150.64,
        "miss"=>92,
        "mae"=>16.6455
    ],
    "domgl"=> [
        "coeff"=>-0.41,
        "x"=>"temp",
        "yi"=>13.85,
        "miss"=>6.8,
        "mae"=>1.6658
    ],
    "dogain"=> [
        "coeff"=>NULL,
        "x"=>NULL,
        "yi"=>NULL,
        "miss"=>NULL,
        "mae"=>NULL
    ],
    "turb"=> [
        "coeff"=>-7.15,
        "x"=>"ph",
        "yi"=>60.23,
        "miss"=>0.4,
        "mae"=>6.1908
    ],
    "depth"=> [
        "coeff"=>NULL,
        "x"=>NULL,
        "yi"=>NULL,
        "miss"=>NULL,
        "mae"=>NULL
    ]    
];*/
?>