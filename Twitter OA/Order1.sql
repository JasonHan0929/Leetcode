/*
Enter your query here.
*/
select o.customerNumber as customer
from ORDERS as o
group by customerNumber
order by count(orderNumber) desc
limit 1;
