<?php

// Configuration and create connection.
include_once("class/DB.class.php");
include_once("class/Test.class.php");

$test = new Test();
$test->open();

$response = $test->get_data();
$test->close();

header("Content-Type: application/json; charset=utf-8");
echo json_encode($response);

?>