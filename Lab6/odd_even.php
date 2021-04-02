<?php 
	for ($i = 2; $i <= 20; $i += 2) {
		if($i != 20) {
?>
			<span><?= $i . ", "; ?></span>
<?php
		}
		else {
?>
			<span><?= $i . "."; ?></span>
<?php
		}
	}
?>