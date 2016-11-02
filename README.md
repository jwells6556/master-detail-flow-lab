---
title: Master/Detail Flow
type: Lab
duration: "1:30"
creator:
    name: Charlie Drews
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Grocery List with Master/Detail Flow

## Introduction

> ***Note:*** _This can be a pair programming activity or done independently._

In this lab, we will be continuing our work on the Grocery List.
In the [Detail View Lab](https://github.com/ga-adi-macaron/detail-view-lab) you set up one activity to show a list of grocery items, and a second activity to show detail for a selected item.

For this lab, you will use a detail _fragment_ to show the selected item. If the user's device is large enough (screen width >= 900dp) then show the detail fragment alongside the list, all on one screen.
If the user's device is small (screen width < 900dp) then show the detail fragment in a separate activity instead.

## Exercise

#### Requirements

- Allow the user to click on a grocery item to view product detail
  - If screen width is >= 900dp, show the detail in the same screen as the list, in a separate pane
  - If screen width is < 900dp show the detail in a separate screen (just like it was before in the Detail View lab)
- The detail view should display all four details from the database
- Gather the details for the selected item from the database (not passed through the intent)

**Bonus:**
- Add an additional piece of data to each grocery item which the user can change, e.g. the ability to check off an item to mark it as purchased
  - Add an element in your detail view that can accept user input (e.g. a checkbox)
  - Use a custom interface to communicate the user's action from the detail fragment back to the host activity
  - If the host activity also includes the list, update the list to visually display the change
- Add additional columns to the database and display those on the details screen
- Add an additional activity to allow the user to add more groceries to the list

#### Starter code

The [starter code](starter-code) contains the the solution code to the Detail View lab. If your code from that lab was working properly, you may continue using that codebase instead, if you prefer.

#### Deliverable

A working app that implements the Master/Detail Flow pattern for the grocery list.
If you work with a partner, please put both names in your pull request title.

## Additional Resources

- [Activities and Intents](http://developer.android.com/guide/components/intents-filters.html)
- [SQLite Database Documentation](http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)

---

## Licensing
1. All content is licensed under a CC­BY­NC­SA 4.0 license.
2. All software code is licensed under GNU GPLv3. For commercial use or alternative licensing, please contact [legal@ga.co](mailto:legal@ga.co).
