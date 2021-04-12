<html>
<body>

<?php
$str = "Live Long And Posper.";
$pattern = "/and/i";
echo preg_match($pattern, $str);

$str = "Luke,I Am Your Father.";
$pattern = "/ain/i";
echo preg_match_all($pattern, $str);

$str = "Movie";
$pattern = "/fruit/i";
echo preg_replace($pattern, "Star Wars", $str);
?>

</body>
</html>