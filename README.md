#FontAwesomeFx\n
The most user friendly version of fontawesome library for JavaFX. Use your icons the same way as you use in the web developement.

##Usage
First import the library to your project. In FXML open FontAwesomeIconView tag and pass two parameters to it: **Icon and Color**. This will do the job!

###Icon Name
The following format is accepted for the icon value: 

`{font-group} fa-{font_name}`



**Example:**

`fal fa-trash`

###Color
For color field you simply pass the name of color, say `black` or its hex representation `#000000`.

___

So overall your FontAwesomeIcon tag should look like this:
`<FontAwesomeIconView icon="fad fa-envelope" color="#0085FF"/>`