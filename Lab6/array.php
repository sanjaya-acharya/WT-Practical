<?php
echo '<b>"sort ( )" sorts the array in ascending order.</b><br>';
$arr1 = array(1, 8, 3, 20, 7);
$length = count($arr1);
sort($arr1);
for($x = 0; $x < $length; $x++) {
  echo $arr1[$x] . " ";
}
echo "<br><br>";

echo '<b>"rsort ( )" sorts the array in reverse order or descending order.</b><br>';
$arr2 = array("Apple", "Orange", "Ball");
$length = count($arr2);
rsort($arr2);
for($x = 0; $x < $length; $x++) {
  echo $arr2[$x] . " ";
}
echo "<br><br>";

echo '<b>"asort ( )" sorts the associative array in ascending order with respect to the "value".</b><br>';
$arr3 = array("S1"=>"Sanjaya", "S2"=>"Dipesh", "S3"=>"Sumin", "S4"=>"Ajit", "S5"=>"Bibek", "S6"=>"Nishanta");
asort($arr3);
foreach ($arr3 as $key => $value) {
  echo "Key = " . $key . ", Value = " . $value . "<br>";
}
echo "<br>";

echo '<b>"arsort ( )" sorts the associative array in reverse order or descending order with respect to the "value".</b><br>';
$arr4 = array("S1"=>"Sanjaya", "S2"=>"Dipesh", "S3"=>"Sumin", "S4"=>"Ajit", "S5"=>"Bibek", "S6"=>"Nishanta");
arsort($arr4);
foreach ($arr4 as $key => $value) {
  echo "Key = " . $key . ", Value = " . $value . "<br>";
}
echo "<br>";

echo '<b>"ksort ( )" sorts the associative array in ascending order with respect to the "key".</b><br>';
$arr5 = array("Maths"=>40, "Science"=>50, "C++"=>75, "WT"=>60);
ksort($arr5);
foreach ($arr5 as $key => $value) {
  echo "Key = " . $key . ", Value = " . $value . "<br>";
}
echo "<br><br>";

echo '<b>"krsort ( )" sorts the associative array in reverse order or descending order with respect to the "key"</b>.<br>';
$arr6 = array("Maths"=>40, "Science"=>50, "C++"=>75, "WT"=>60);
krsort($arr6);
foreach ($arr6 as $key => $value) {
  echo "Key = " . $key . "<br>Value = " . $value . "<br><br>";
}

?>