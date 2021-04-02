<html>
<body>

<?php
	class myClass {
		public $var1;

		function setData($var1) {
			$this->var1 = $var1;
		}

		function displayData() {
			return $this->var1;
		}
	};

	$Object1 = new myClass;
	$Object2 = new myClass;

	$Object1->setData('This is Object 1');
	$Object2->setData('This is Object 2');
?>

<h1><?= $Object1->displayData(); ?></h1>
<p><?= $Object2->displayData(); ?></p>
 
</body>
</html>