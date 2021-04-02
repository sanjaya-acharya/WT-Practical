<?php

require_once("./Employee.php");
require_once("./Company.php");
$gces = new Company;

$gces->name = "Gandaki College of Engineering and Science";
$gces->address = "Lamachaur, Pokhara-16";

array_push($gces->employees, new Employee("Sanjaya", "LC"));

?>

<!DOCTYPE html>
<html>

<head>
	<title>detail.php</title>

	<style type="text/css">
		table {
			border-collapse: collapse;
		}
		td, th{
			border:1px solid black;
			font-size: 30px;
			padding: 10px;
		}
	</style>
</head>

<body>

<table>
	<thead>
		<tr>
			<th>Employee's Name</th>
			<th>Address</th>
		</tr>
	</thead>

	<tbody>

		<?php 
			foreach ($gces->employees as $employee) {
		?>
		<tr>
			<td> <?= "$employee->name" ?> </td>
			<td> <?= "$employee->address" ?> </td>
		</tr>

		<?php
			}
		?>
	</tbody>
</table>


</body>

</html>