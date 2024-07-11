
## Guvi Zen Tasks done by Name here

1. **Fix the bugs in below snippet**

Original:

```HTML
    <html lang="en">
    <head>
        <title>Document
            <body>
                guvi
        </title>
    </head>
    <div>
        Lorem ipsum dolor sit amet consectetur adipisicing elit.
        <div>
            <div>
                Guvi Geek Network
            </div>
        </body>
    </html>
```

Fixed:

```HTML
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
    guvi
    <div>
        Lorem ipsum dolor sit amet consectetur adipisicing elit.
        <div>
            <div>
                Guvi Geek Network
            </div>
        </div>
    </div>
</body>
</html>
```

2. **Try the below one**

Original:

```HTML
<html lang="en">
    <head>
        <title>Document
            <body>
                guvi
    </head>
    <div>
        Lorem ipsum dolor sit amet consectetur adipisicing elit.
        <div>
            <div>
                Guvi Geek Network
            </div>
        </body>
    </html>
```

Fixed:

```HTML
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
    guvi
    <div>
        Lorem ipsum dolor sit amet consectetur adipisicing elit.
        <div>
            <div>
                Guvi Geek Network
            </div>
        </div>
    </div>
</body>
</html>
```

---

3. **Design a contact us form with all fields as required.**

```HTML
<html lang="en">
<head>
    <title>Contact Us</title>
</head>
<body>
    <form>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" required><br><br>
        
        <label for="message">Message:</label><br>
        <textarea id="message" name="message" required></textarea><br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
```

---

4. **Use certain HTML elements to display the following in a HTML page.**

```HTML
<html lang="en">
<head>
    <title>Programming and Databases</title>
</head>
<body>
    <ul>
        <li>Programming Language
            <ul>
                <li>JavaScript
                    <ol>
                        <li>Angular</li>
                        <li>React</li>
                        <li>Vue.js</li>
                    </ol>
                </li>
                <li>Python
                    <ol>
                        <li>Django Framework</li>
                        <li>Flask Framework</li>
                    </ol>
                </li>
                <li>Java
                    <ol>
                        <li>Spring</li>
                        <li>Maven</li>
                        <li>Hibernate</li>
                    </ol>
                </li>
            </ul>
        </li>
        <li>Database
            <ul>
                <li>MySQL</li>
                <li>MongoDB</li>
                <li>Cassandra</li>
            </ul>
        </li>
    </ul>
</body>
</html>
```

---

5. **Create an element that helps you to open https://google.com in a separate new tab.**

```HTML
<html lang="en">
<head>
    <title>Open Google</title>
</head>
<body>
    <a href="https://google.com" target="_blank">Open Google</a>
</body>
</html>
```

---

6. **In the form, add two radio buttons with grouping them for employee type (Salaried and own business).**

```HTML
<html lang="en">
<head>
    <title>Employee Type</title>
</head>
<body>
    <form>
        <label for="salaried">Salaried</label>
        <input type="radio" id="salaried" name="employee_type" value="salaried" required>
        
        <label for="business">Own Business</label>
        <input type="radio" id="business" name="employee_type" value="business" required><br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
```

---

7. **Design form shown in the link.-Aadhar**

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aadhaar Card</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .aadhaar-card {
            width: 350px;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            position: relative;
            border: 1px solid #ddd;
        }

        .header {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-bottom: 10px;
        }

        .emblem {
            width: 50px;
            height: 50px;
            background-color: #000;
            border-radius: 50%;
            margin-right: 10px;
        }

        .govt-info p {
            margin: 0;
            font-size: 12px;
            line-height: 1.2;
        }

        .flag {
            width: 100%;
            height: 10px;
            background: linear-gradient(90deg, #FF9933 33%, #FFFFFF 33%, #FFFFFF 66%, #138808 66%);
            margin-bottom: 10px;
        }

        .profile-section {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
        }

        .profile-picture {
            width: 80px;
            height: 100px;
            background-color: #ccc;
            border: 1px solid #ddd;
            margin-right: 10px;
        }

        .profile-details {
            text-align: left;
            flex: 1;
        }

        .profile-details p {
            margin: 5px 0;
            font-size: 12px;
        }

        .telugu {
            font-family: 'Noto Sans Telugu', sans-serif;
        }

        .qr-code {
            width: 80px;
            height: 80px;
            background-color: #000;
        }

        .aadhaar-number {
            font-size: 18px;
            font-weight: bold;
            letter-spacing: 2px;
            margin: 10px 0;
        }

        .footer {
            position: absolute;
            bottom: 10px;
            left: 0;
            right: 0;
            border-top: 1px solid #ddd;
            padding-top: 5px;
        }

        .footer p {
            font-size: 14px;
            color: red;
            font-weight: bold;
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="aadhaar-card">
        <div class="header">
            <div class="emblem"></div>
            <div class="govt-info">
                <p>भारत सरकार</p>
                <p>GOVERNMENT OF INDIA</p>
            </div>
        </div>
        <div class="flag"></div>
        <div class="profile-section">
            <div class="profile-picture"></div>
            <div class="profile-details">
                <p class="telugu">చందు ప్రదీప్</p>
                <p>Name: XXXX</p>
                <p>DOB: XX-XX-XXXX</p>
                <p>Gender: MALE</p>
            </div>
            <div class="qr-code"></div>
        </div>
        <div class="aadhaar-number">
            0000 1111 2222
        </div>
        <div class="footer">
            <p>आधार - आम आदमी का अधिकार</p>
        </div>
    </div>
</body>
</html>

```

---

8. **Use the table tag to design given image.-Voter ID**

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voter ID Card</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .card-container {
            display: flex;
            gap: 20px;
        }
        .card {
            width: 300px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: left;
            border: 1px solid #ccc;
        }
        .header {
            text-align: center;
            margin-bottom: 10px;
        }
        .emblem {
            width: 50px;
            height: 50px;
            background: #000; /* Placeholder for emblem */
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 10px;
            margin: 0 auto;
        }
        .header h1 {
            font-size: 16px;
            margin: 10px 0 5px;
        }
        .header h2 {
            font-size: 14px;
            margin: 0;
        }
        .profile-section {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }
        .profile {
            width: 60px;
            height: 80px;
            background: #ccc; /* Placeholder for profile picture */
            border-radius: 5px;
            margin-right: 10px;
            text-align: center;
            line-height: 80px;
            color: white;
            font-size: 12px;
        }
        .details {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        .details p {
            margin: 5px 0;
            font-size: 12px;
        }
        .sign-section {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            margin-top: 20px;
        }
        .sign-section p {
            margin: 5px 0;
            font-size: 12px;
        }
        .signature {
            width: 100px;
            height: 30px;
            background: #ccc; /* Placeholder for signature */
            border-radius: 5px;
            text-align: center;
            line-height: 30px;
            color: white;
            font-size: 12px;
        }
        .id-number {
            text-align: right;
            font-size: 12px;
            margin-top: 20px;
        }
        .address-section {
            margin-top: 20px;
        }
        .address-section p {
            margin: 5px 0;
            font-size: 12px;
        }
    </style>
</head>
<body>
    <div class="card-container">
        <div class="card">
            <div class="header">
                <div class="emblem">EMBLEM</div>
                <h1>Election Commission of India</h1>
                <h2>Identity Card</h2>
                <p>UTC026351</p>
            </div>
            <div class="profile-section">
                <div class="profile">PHOTO</div>
                <div class="details">
                    <p>Name: XXXXX</p>
                    <p>Father's Name: XXXXXXX</p>
                    <p>Sex: M/F</p>
                    <p>Date of Birth: XX-XX-XXXX</p>
                </div>
            </div>
            <div class="id-number">
                <p>20/10235689</p>
            </div>
        </div>
        <div class="card">
            <div class="header">
                <p>UTC026351</p>
            </div>
            <div class="address-section">
                <p>Address:</p>
                <p>XXXXXXXXXXXXXXXXX</p>
                  <p>XXXXXXXXXXXXX</p>
                    <p>XXXXXXXX</p>
                      <p>XXXXX</p>
            </div>
            <div class="sign-section">
                <p>Date  : XXXXXXXXXX</p>
                <div class="signature">SIGN</div>
                <p>Officer Signature</p>
            </div>
        </div>
    </div>
</body>
</html>

```

---

9. **Write HTML input tags snippet to show default values for all Form elements.**

```HTML
<html lang="en">
<head>
    <title>Form Elements with Default Values</title>
</head>
<body>
    <form>
        <label for="text">Text:</label>
        <input type="text" id="text" name="text" value="Default Text"><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="123456"><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="example@mail.com"><br><br>
        
        <label for="date">Date:</label>
        <input type="date" id="date" name="date" value="2024-01-01"><br><br>
        
        <label for="color">Color:</label>
        <input type="color" id="color" name="color" value="#ff0000"><br><br>
        
        <label for="number">Number:</label>
        <input type="number" id="number" name="number" value="10"><br><br>
        
        <label for="range">Range:</label>
        <input type="range" id="range" name="range" value="50"><br><br>
        
        <label for="textarea">Textarea:</label><br>
        <textarea id="textarea" name="textarea">Default Text</textarea><br><br>
        
        <label for="checkbox">Checkbox:</label>
        <input type="checkbox" id="checkbox" name="checkbox" checked><br><br>
        
        <label for="radio">Radio:</label>
        <input type="radio" id="radio" name="radio" checked><br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
```

---

10. **In your HTML page add the below line and Highlight it without using any CSS.**

```HTML
<html lang="en">
<head>
    <title>Highlight Text</title>
</head>
<body>
    <b>"HTML & CSS is awesome"</b>
</body>
</html>
```

---

11. **Create an HTML page, which should contain all types of input elements.**

```HTML
<html lang="en">
<head>
    <title>All Input Elements</title>
</head>
<body>
    <form>
        <label for="text">Text:</label>
        <input type="text" id="text" name="text"><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
        <br>
        <br>
        <label for="date">Date:</label>
        <input type="date" id="date" name="date"><br><br>
        
        <label for="color">Color:</label>
        <input type="color" id="color" name="color"><br><br>
        
        <label for="number">Number:</label>
        <input type="number" id="number" name="number"><br><br>
        
        <label for="range">Range:</label>
        <input type="range" id="range" name="range"><br><br>
        
        <label for="textarea">Textarea:</label><br>
        <textarea id="textarea" name="textarea"></textarea><br><br>
        
        <label for="checkbox">Checkbox:</label>
        <input type="checkbox" id="checkbox" name="checkbox"><br><br>
        
        <label for="radio">Radio:</label>
        <input type="radio" id="radio" name="radio"><br><br>
        
        <label for="file">File:</label>
        <input type="file" id="file" name="file"><br><br>
        
        <label for="hidden">Hidden:</label>
        <input type="hidden" id="hidden" name="hidden" value="hidden"><br><br>
        
        <label for="search">Search:</label>
        <input type="search" id="search" name="search"><br><br>
        
        <label for="tel">Tel:</label>
        <input type="tel" id="tel" name="tel"><br><br>
        
        <label for="url">URL:</label>
        <input type="url" id="url" name="url"><br><br>
        
        <button type="submit">Submit</button>
    </form>
</body>
</html>
```
