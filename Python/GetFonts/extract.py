import os
import re
import surrogates

from selenium import webdriver
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
from selenium.webdriver.common.by import By

from time import sleep


# Initiating browser
caps = DesiredCapabilities().CHROME
caps["pageLoadStrategy"] = "eager"
driver = webdriver.Chrome(desired_capabilities=caps)
driver.get("http://www.russellcottrell.com/greek/utilities/SurrogatePairCalculator.htm")


css = open("all.css","r")
icon = ""
_unicode = ""
icons=[]


def get_surrogate_pair(icon):
	scalar = driver.find_element_by_name('scalar')
	scalar.clear()
	scalar.send_keys(icon)
	
	scalar = driver.find_elements(By.XPATH,"//a")[0]
	scalar.click()
	# sleep(1)
	
	left = driver.find_element_by_name("hi")
	right = driver.find_element_by_name("lo")

	return "\\u"+left.get_attribute("value") + "\\u" + right.get_attribute("value")
	# print(surrogates.encode(""))



for line in css:
	# print(line)
	if re.search(r"(?=fa-).+(?::)",line):
		_match = re.search(r"(?<=fa-).+(?=:)",line)
		icon = _match.group(0).replace("-","_").upper()
		if icon in icons:
			icon="FAD_"+icon
		icons.append(icon)
	if re.search(r"(?<=content:\s\").+(?=\")",line):
		_match = re.search(r"(?<=content:\s\").+(?=\")",line)
		_unicode = _match.group(0).replace("\\","\\u")
		if re.search("FAD_",icon):
			_unicode = get_surrogate_pair(_match.group(0).replace("\\",""))
	if len(icon)>0 and len(_unicode)>0:
		# print(icon+'("'+_unicode+'"),')
		print('"'+icon+'" : '+'"'+_unicode+'",')
		icon=""
		_unicode=""





