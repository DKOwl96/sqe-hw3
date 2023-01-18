/* @Provengo summon selenium */

//TODO: asserts
/**
 *  The user Login
 */
defineEvent(SeleniumSession, "Login", function(session, e) {
  bp.log.info(e);
  session.writeText("//input[@id='field-email']", e.username);
  session.writeText("//input[@id='field-password']", e.password);
  session.click("//*[@id='submit-login']");
})

/**
 * Select product to comment on
 */
defineEvent(SeleniumSession, "SelectProduct", function (session, e) {
  session.click("//*[@id='content']/section[3]/div/div[4]/article/div/div[1]/a/img");
})

/**
 * The AddComment event defines the flow of commenting on product
 */
defineEvent(SeleniumSession, "AddComment", function(session, e) {
  // click on "write your review" button
  try {
    session.click("//*[@id='add-to-cart-or-refresh']/div[3]/div[2]/button");
    // fill up the "Title" and the "Review" boxes
    session.writeText("//*[@id='post-product-comment-form']/div[2]/div/input", "test title");
    session.writeText("//*[@id='post-product-comment-form']/div[4]/div/textarea", "test review");
    // click on "send" button
    session.click("//*[@id='post-product-comment-form']/div[6]/div[2]/button[2]");
  }
  catch (e) {
    pass;
  }
})

/**
 *  The admin login
 */
defineEvent(SeleniumSession, "AdminLogin", function(session, e) {
  bp.log.info(e);
  session.writeText("//*[@id='email']", e.username);
  session.writeText("// *[@id='passwd']", e.password);
  session.click("//*[@id='submit_login']");
})

/**
 * Navigate to "Product Comments" module in order to disable the commenting
 */
defineEvent(SeleniumSession, "NavigateTo", function(session, e) {
  //opening the bar
  session.click("//*[@id=\"header_infos\"]/i");
  // selecting "modules"
  session.click("//*[@id=\"subtab-AdminParentModulesSf\"]/a/i[2]");
  // selecting "module manger"
  session.click("//*[@id=\"subtab-AdminModulesSf\"]/a");
  // searching for the "Product Comments" module by typing "comment" in the search bar
  session.writeText("//*[@id=\"search-input-group\"]/div[1]/div[2]/input", "comment");
  // opening the "Product Comments" module
  session.click("//*[@id='module-search-button']/i");
})

/**
 * The DisableCommenting event defines the
 */
defineEvent(SeleniumSession, "DisableCommenting", function(session, e) {
  // opening module menue
  session.click("//*[@id='modules-list-container-theme_modules']/div/div/div/div[2]/div[4]/div[2]/button");
  // selecting "disable"
  session.click("//*[@id='modules-list-container-theme_modules']/div/div/div/div[2]/div[4]/div[2]/div/li[2]/form/button")
  //approving disabling
  //TODO: click "yes" on popup window only if exists
  session.click("//*[@id=\"module-modal-confirm-productcomments-disable\"]/div/div/div[3]/a")
})


/**
 * Admin enabling the commenting
 */
defineEvent(SeleniumSession, "EnableCommenting", function(session, e) {
  if (session.assertText.modifiers.Negate("//*[@id=\"add-to-cart-or-refresh\"]/div[3]", "//*[@id=\"add-to-cart-or-refresh\"]/div[3]/div[2]"))
    session.click("//*[@id='modules-list-container-theme_modules']/div/div/div/div[2]/div[4]/div[2]/form/button")
})