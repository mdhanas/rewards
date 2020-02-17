# Rewards
Rewards Calculation Application 

Simple Spring Boot Application written in Java 8 to calculate rewards of the customers in last 3 months sales per month and its total. 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Application uses in-memory H2 Database and data are loaded through data.sql while app being initialized.

Sample Input as of 2/16/2020:
```
INSERT INTO CUSTOMER_SALES VALUES ('1','1','100','2020-01-15', '1'); // point should be 50 for 1st month
INSERT INTO CUSTOMER_SALES VALUES ('2','1','120','2020-02-10', '2'); // point should be 90 (2 *20 + 1*50) for 2nd month
INSERT INTO CUSTOMER_SALES VALUES ('3','1','120','2019-08-01', '8'); // should be ignored as sales is not in last 3 months
INSERT INTO CUSTOMER_SALES VALUES ('4','1','50','2020-01-12', '1'); // zero points 

INSERT INTO CUSTOMER_SALES VALUES ('5','2','50','2020-02-10', '2'); // point should be 0  for 2nd month
INSERT INTO CUSTOMER_SALES VALUES ('6','2','101','2020-01-01', '1'); // point should be 52 (1*2 + 1*50)for 1st month
INSERT INTO CUSTOMER_SALES VALUES ('7','2','51','2020-01-16', '1'); // point should be 1 for 1st month
INSERT INTO CUSTOMER_SALES VALUES ('8','2','300','2020-02-12', '3'); // point should be (200*2 + 50) - 450 for 3rd month
INSERT INTO CUSTOMER_SALES VALUES ('9','2','175','2020-01-12', '1'); // point should be (75*2 + 50) - 200 for 1st month

INSERT INTO CUSTOMER_SALES VALUES ('10','3','89','2019-12-02', '12'); // point should be (39) for 12th month
```

Sample Output as of 2/16/2020:
```
[
    {
        "firstName": "First",
        "lastName": "Customer",
        "monthlySales": [
            {
                "month": 1,
                "sales": 150,
                "rewardPoints": 50
            },
            {
                "month": 2,
                "sales": 120,
                "rewardPoints": 90
            }
        ],
        "totalSales": 270,
        "totalRewardPoints": 140
    },
    {
        "firstName": "Second",
        "lastName": "Customer",
        "monthlySales": [
            {
                "month": 1,
                "sales": 327,
                "rewardPoints": 253
            },
            {
                "month": 2,
                "sales": 50,
                "rewardPoints": 0
            },
            {
                "month": 3,
                "sales": 300,
                "rewardPoints": 450
            }
        ],
        "totalSales": 677,
        "totalRewardPoints": 703
    },
    {
        "firstName": "Third",
        "lastName": "Customer",
        "monthlySales": [
            {
                "month": 12,
                "sales": 89,
                "rewardPoints": 39
            }
        ],
        "totalSales": 89,
        "totalRewardPoints": 39
    }
]
```
