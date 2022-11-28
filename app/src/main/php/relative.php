<?php

// Configuration and create connection.
include_once("class/DB.class.php");
include_once("class/Relative.class.php");

$relative = new Relative();
$relative->open();

$response["status"] = 1;

if($_POST['method'] == "signup")
{
    $relative->get_user($_POST['email']);
    if($relative->get_row() == 0)
    {
        $password = md5($_POST['password']);
        $relative->add_data($_POST['email'], $_POST['name'], $password);
        
        $response["status"] = 0;
    }
}
else if($_POST['method'] == "login")
{
    $relative->get_user($_POST['email']);
    if($relative->get_row() == 1)
    {
        while(list($email, $name, $password) = $relative->get_result())
        {
            $account['email'] = $email;
            $account['password'] = $password;
        }

        $password = md5($_POST['password']);
        if(($account['email'] == $_POST['email']) && ($account['password'] == $password))
        {
            $response["status"] = 0;
        }
    }
}

$relative->close();

header("Content-Type: application/json; charset=utf-8");
echo json_encode($response);

?>