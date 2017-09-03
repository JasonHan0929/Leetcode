CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE M INT;
  SET M = N -1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT CASE WHEN COUNT(DISTINCT Salary) >= N THEN (
        SELECT DISTINCT Salary From Employee ORDER BY Salary DESC LIMIT M, 1)
      ELSE NULL
      END
      FROM Employee
  );
END
