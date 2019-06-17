========================================================
HelpNDoc Version 3.7.1.482
========================================================

This file contains useful information about HelpNDoc, an easy to use yet powerful and intuitive environment to create help files and documentations.

--------------------------------------------------------
CONTENTS
--------------------------------------------------------

1. Welcome!
2. System Requirements
3. Installing HelpNDoc
4. First steps with HelpNDoc
5. Purchasing HelpNDoc
6. Version Information
7. Obtaining technical support

--------------------------------------------------------
1. Welcome!
--------------------------------------------------------

IBE Software would like to welcome you to HelpNDoc. We, at IBE Software, believe that you will never see the creation of help files and documentations the same way as before using HelpNDoc.

--------------------------------------------------------
2. System Requirements
--------------------------------------------------------

Recommended Configuration:
  - Windows XP, Windows Vista or Windows 7
  - 512MB of RAM 
  - 80MB of free disk space
  - 1024x768 screen resolution or higher
  - Help Compiler: Microsoft HTML Help Workshop. Download: http://go.microsoft.com/fwlink/?LinkId=14188
  - MobiPocket/Kindle Compiler : Amazon KindleGen. Download: http://www.amazon.com/kindleformat/KindleGen

--------------------------------------------------------
3. Installing HelpNDoc
--------------------------------------------------------

Just run the helpndoc-setup.exe file and follow the instructions. You can install HelpNDoc over a previously installed version. Don't forget to backup any existing project prior to updating.

--------------------------------------------------------
4. First steps with HelpNDoc
--------------------------------------------------------

You can use the help file to help you get started with the environment.

--------------------------------------------------------
5. Purchasing HelpNDoc
--------------------------------------------------------

You can find more information about ordering HelpNDoc by following this link:
http://www.helpndoc.com/store

--------------------------------------------------------
6. Version Information
--------------------------------------------------------

V3.7.1.482 - November 19, 2012

* HTML documentation could not always select the first displayed table of contents item when viewed from a remote server
* A frame was displayed around the content when printing a CHM topic
* Word generator always compressed bitmap pictures even if the option for automatic compression was not checked
* The Word documentation wasn't generated if the used template didn't show the table of contents
* Word documentations could add extra empty lines before topic titles
* French translation errors in the documentation generation log
* The recent projects and places lists weren't correctly saved to the registry which could lead to incorrect entries

V3.7.0.456 - October 25, 2012

+ Conditional build system: control which part of the documentation is present in each build through conditional tags
+ Added keyboard shortcuts to insert/move/delete/edit properties of keywords and library items (CTRL+INSERT, CTRL+ARROW, CTRL+DELETE, CTRL+ENTER)
+ Some Central/Eastern European characters may appear broken in the CHM search result list: fixed with the CHM template option "Use project charset for topics"
+ Option to enable only the selected build and rename a build in the build generation list
+ Popup menu for easier and faster build management in the build generation list
+ It is now possible to clear recent projects and places from the option dialog
* Some fonts with custom spacing could produce overlapping characters in PDF documents
* Better support for bookmarks in PDF documents
* Some Central European characters were not correctly generated in the CHM table of contents
* Better support for some OpenOffice.org dictionaries
* Creating a new blank project didn't set up default project language which could lead to empty title for CHM documentation
* Google Chrome now correctly displays the table of contents for HTML documentations when viewed locally
* Topics with large caption could have duplicate auto-generated help IDs
* Word and PDF documentation didn't add requested page breaks when topic titles were hidden
* Parts of the table of contents of some rare CHM help files could not be imported
* CHM documentation didn't correctly display table background images and bullet lists images
* Recent projects and places could contain invalid paths

V3.6.0.345 - July 11, 2012

+ New build system: create as many customized build of any documentation format as needed. Warning: command line changes
+ Added support for invisible topics: invisible topics and their children won't be generated in any documentation format
+ Relative external library items are now imported at generation time
+ It is now possible to indent bullets and numbering with the TAB key
* EPub and Mobi generators didn't correctly generate link topic kinds
* EPub generator didn't correctly escape Some characters which could lead to errors on the iPad
* Norwegian dictionary from OpenOffice.org didn't install correctly
* The default HTML template generated un-balanced HTML comments
* RTF importer didn't correctly import relative hyperlinks
* Empty topics could produce corrupted PDF table of contents
* HTML documentation could cause errors when tabs where hidden
* HTML search engine didn't find words containing the "T" character
* Color dialog now saves custom colors
* HTML based generators will correctly update topic files when the character case has changed

V3.5.1.288 - May 17, 2012

* HTML documentation produced errors in web-browsers when topic captions contained quotes or double quotes
* PDF documentation could display weird page numbering text on the first page
* Generate Mobipocket/Kindle checkbox was always checked in generation dialog

V3.5.0.284 - May 14, 2012

+ HelpNDoc software and help file has been translated to French
+ HelpNDoc can now generate standard EPub EBooks
+ HelpNDoc can now generate Mobipocket/Kindle EBooks
+ HTML based documentation can now optionally  skip exporting the default font style to rely on the web-browser's settings
+ HTML based documentation can now optionally  use percentage for the font size instead of points
+ Insert hyperlink dialog window is now resizable and size is saved for next time it is used
+ Re-introduced shortcuts to move, add or delete topics (CTRL+Arrows, CTRL+[SHIFT+]INSERT, CTRL+DELETE)
+ It is now possible to generate Word and PDF documentation in landscape mode
+ Completed percentage in the generation log window for long actions
* Internet Explorer could display an error about invalid characters in the table of contents for HTML documentation
* HTML based generators won't alter PHP or ASP code at generation time
* Relative topic links were not working for CHM documentations anymore
* Bullets and numberings are not generated as texts by default for HTML based documentation anymore as it didn't always produce good results
* "Enum" template settings could be rendered incorrectly in the generation settings dialog's list
* HelpNDoc could take a long time to launch if a recent networked location was not available
* An error occurred when clearing a text template variable in the customize dialog
* Checkbox controls were not displayed in the keywords panel when Windows themes were not enabled
* Keyword popup in HTML documentation now displays a close button

V3.4.2.197 - March 30, 2012
  
* When optimizing pictures, some of them could become empty or black PNG files for HTML and CHM documentation

V3.4.1.188 - March 26, 2012

* All generators are now using less memory and GDI resources
* Better PNG transparency in Word generated documentation
* Cursor was moved to the beginning of the topic text after pasting
* Library items were not always correctly replaced at generation time
* Customize template links were missing from the project options

V3.4.0.166 - March 6, 2012

+ CHM and HTML Templates can now support customization from within HelpNDoc
+ Various HTML template customization settings added: base color, visible tabs, expansion status, texts, icon sets...
+ CHM and HTML Templates: Export numbered lists as text by default which usually looks closer to original. Customizable in template settings
+ HTML Template: The table of contents tree is now synchronized with the displayed topic
+ HTML Template: Icons set in HelpNDoc are now used in the table of contents
+ CHM Template: Set the table of contents font from HelpNDoc
+ PDF and Word Templates: It is now possible to use numbering for topic headings
* Copying and pasting multiple topics did not correctly paste their content
* CHM Template: CHM file couldn't be open using the help ID
* iPhone template enhancement: the footer DIV wasn't closed properly
* Style were not always correctly applied to selected text
* Word and PDF generators sometimes didn't take the updated style properties into account
* Fixed a rare exception which could occur when the live spell check was enabled and a table cell was edited
* Custom dictionary file was always overwritten when HelpNDoc was updated
* Terms were not always correctly encoded in the HTML search engine
* Word and PDF generators did focus the first topic after generation
* Word generator didn't display errors when launched from the quick generate popup
* Word and PDF generators could produce memory leaks after generation
* Pasted pictures could become broken if dragged before the topic had been saved
* Code template for "C/C++ Defines" didn't generate correct code
* Table columns and rows are now easier to select with the mouse

V3.3.0.123 - January 12, 2012

+ New "Paste as text" and "Paste special" commands for finer paste control
+ New template to export HTML documentation based on JQuery mobile
+ Pictures pasted or imported as part of a document are now automatically compressed before being saved to the HND project file
+ Reintroduced the extended table of contents feature
+ New visual identification about panel docking similar to Visual Studio
* Opening project files containing a single quote displayed a SafeCall error
* F1 shortcut didn't display the help file
* Expand and compact shortcut keys only worked from the numerical keyboard
* An error could sometimes happen when CTRL+Clicking on hyperlinks
* Restored windows' height on launch was always smaller than when closed
* Text contained in tables couldn't be added as keywords
* Regression as the Brazilian dictionary couldn't be installed anymore
* Cleaned-up keyboard shortcuts for Ribbon items in accordance to MS Word
* Default HTML template did show an error with keywords containing quotes
* Using the insert table popup from the quick access toolbar displayed an error message

V3.2.0.65 - November 8, 2011

+ Reintroduced the CHM purge option: uncheck the "Keep temporary files" to remove any temporary file or directory generated by the CHM template
+ Template inheritance support: specify the parent template and only override the specified files
+ A table of contents with page numbers can be generated at the top of Word and PDF documentation formats
+ Reintroduced the "Add as keyword" context menu item in the topic editor
+ Currently selected text is used as default caption when adding a keyword
+ Use CTRL+Click in the topic editor to follow an hyperlink
* HTML documentation can now display the index or search tabs by default by adding the #_index or #_search tag at the end of the documentation URL
* HTML template was not correctly mentioning the UTF-8 charset in the head section
* iPhone template had some issues with topic titles
* Selecting an output path for the generated documentation didn't default to the currently specified one
* An error happened when activating the Turkish dictionary
* The progress bar didn't show on lengthy project find/replace operations
* The horizontal scrollbar was shown in the topic editor for no reason on small screens
* Topic editor's popup menu now correctly displays spelling errors first using a bold font and cut/copy/paste last to mimic Word's behavior
* Provide a link to Microsoft HTML Help Workshop when not installed
* Find/Replace within the project is more reliable
* Some pictures could fail optimization when generating CHM and HTML and block subsequent content from begin generated
* Better handling of project related errors while opening/closing/saving

V3.1.0.23 - September 30, 2011

* The PDF generator could fail with an error message in some conditions

V3.1.0.19 - September 26, 2011

+ Added the vacuum command in project options to clean the project and gain some file weight from deleted items
+ New table functionalities: split table, sort table rows and convert table to text
+ Option to automatically compress uncompressed pictures included in the library to generate smaller documentation files
* Links to e-mail address containing a dot were considered as links to Internet addresses when edited
* Paragraph border action wasn't available anymore
* In some rare cases due to Windows user name, HelpNDoc could show an error when launched and stop after that
* Hungarian letters with double acute were not generated correctly in CHM
* Underline font style property was not correctly saved
* V2 projects with big context numbers could not be imported
* Slash shortcut "/" is reintroduced to recursively collapse all children
* Performance improvements when getting the list of anchors in the topic link dialog
* Listed anchors in the topic link dialog didn't include anchors in table cells
* Changing the background color of the paragraph did reset some other attributes such as alignment
* Locating a search result didn't select it in the topic editor if it was not in the currently edited topic
* Pasting or dropping an image into the topic editor could generate file names without a valid extension
* Table background pictures were not displayed in HTML based documentation
* Under some conditions the styles applied in topic editor was not correctly saved and restored
* Renaming a topic with non ASCII characters could generate an empty Help ID
* OpenOffice.org's Brazilian Portuguese dictionaries couldn't be installed

V3.0.2.24 - September 6, 2011

+ Command line option is back with the possibility to specify template names
+ Topic editor ruler has been restored. Visibility is controlled in options and is hidden by default
* Performance improvement when using and scrolling through the table of contents hierarchy
* Configuration options were saved even when the cancel button was clicked
* CHM and HTML documentation could show an horizontal scroll bar with 100% tables
* Padding wasn't always respected in table cells
* Topic title variables were not correctly substituted
* Documentation now contains the list and description of available methods from within templates

V3.0.1.14 - August 31, 2011

* After opening an existing project, the topic footer was not generated anymore
* Some library items not saved when a project is closed could be saved in the next created one

V3.0.1.12 - August 30, 2011

+ CHM importer can now correctly import and interpret links to topics
* Rewritten project file creating/opening mechanisms to avoid errors
* HTML template had a few graphical glitches in Internet Explorer 7 and 8
* Importing files could produce projects files larger than necessary
* Opening the link dialog for large projects could cause heavy memory usage
* External library items file are now relative to the project's location if a relative path is specified
* Directly calling an HTML page with an anchor didn't work
* Topic with content from an external file had no content in HTML and CHM

V3.0.0.223 - August 23, 2011

+ First public release of HelpNDoc 3.0
* HelpNDoc will now display an error message if opening an unknown project file
* JavaScript search engine didn't return any results in IE7 and IE8
* The paragraph borders and backgrounds button didn't work

--------------------------------------------------------
7. Obtaining technical support
--------------------------------------------------------

Website: http://www.helpndoc.com
E-Mail: support@ibe-software.com

________________________________________________________
Copyright(c) IBE Software 2003 - 2012