/* @provengo summon selenium */

/**
 * This story opens a new browser window, goes to XXXXX.
 * login as user.
 * add comment
 */
story('Add a comment', function () {
  with (new SeleniumSession().start('http://localhost:8080/login')) {
    login({ username: 'DK@gmail.com', password: 'DK12345!!'})
    selectProduct()
    try {
      addComment()
      OkPopup()
    }
    catch (e) {
      // in case the disable happened before commenting
      pass
    }
  }
})

/**
 * This story opens a new browser window, goes to XXXXX.
 * login as Admin.
 * disable the authorization to comment
 */
story('disable the authorization to comment', function () {
  // the "with" statement makes it redundant to write "s." before each call to a defined event (like the story above)
  with (new SeleniumSession().start('http://localhost:8080/adminpatritech')) {
    adminLogin({ username: 'kapustya@post.bgu.ac.il', password: 'Demo12345!'})
    navigateTo();
    disableCommenting();
  }
})