<!-- php string -->
<?php

// strcmp
echo strcmp("Hello","Hello")."<br>";

// strlen
echo strlen("Hello")."<br>";

// print
print "Hello world!<br>";

// number_format
echo number_format("10000000",2)."<br>";
?>

<!-- php array -->
<?php
$names = array("sanjay"=>"LC", "john"=>"bagar", "awg"=>"dggs");
sort($names);

rsort($names);

asort($names);

ksort($names);

arsort($names);

krsort($names);
?>