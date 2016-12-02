
    package de.mayflower.lib.ui;

    import  android.app.*;
    import  android.content.*;
    import  android.content.res.*;
    import  android.graphics.*;
    import  android.graphics.drawable.*;
    import  android.text.*;
    import  android.view.*;
    import  android.view.inputmethod.*;
    import  android.widget.*;
    import  java.util.*;
    import  de.mayflower.lib.*;
    import  de.mayflower.soundboard.R;

    /************************************************************************
    *   All independent UI-functions.
    *
    *   @author     $Author: schristopher $
    *   @version    $Rev: 50546 $ $Date: 2013-08-09 16:19:00 +0200 (Fr, 09 Aug 2013) $
    *   @see        "$URL: http://svn.synapsy.net/svn/Synapsy/PicFood/android/PicFood_1_0/trunk/src_lib/com/synapsy/android/lib/ui/LibUI.java $"
    ************************************************************************/
    public class LibUI
    {
        /************************************************************************
        *   Removes all views of the specified ViewGroup.
        *   This method is performed on the UI-Thread.
        *
        *   @param  activity        The according activity context.
        *   @param  viewGroup       The ViewGroup to remove all views from.
        ************************************************************************/
        public static final void removeAllViewsUIThreaded( Activity activity, final ViewGroup viewGroup )
        {
            activity.runOnUiThread
            (
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        viewGroup.removeAllViews();
                    }
                }
            );
        }

        /************************************************************************
        *   Sets up a {@link Button} with the major attributes.
        *
        *   @param  activity        The current system context.
        *   @param  buttonId        The id of the button to configure.
        *   @param  textID          The resource-ID for the caption of this button.
        *   @param  action          The OnClick-action.
        ************************************************************************/
        public static final void setupButton( Activity activity, int buttonId, int textID, Runnable action )
        {
            Button  button = (Button)activity.findViewById(R.id.button_welcome);
            Spanned text   = LibResource.getResourceSpannedString( activity, textID );

            button.setText( text, TextView.BufferType.SPANNABLE );

            LibUI.setOnClickAction( button, action );
        }

        /************************************************************************
        *   Sets up a {@link TextView} with the major attributes.
        *
        *   @param  context         The current system context.
        *   @param  textView        The TextView to configure.
        *   @param  typeface        The typeface to use for the caption.
        *   @param  textID          The resource-ID for the caption of this button.
        ************************************************************************/
        public static final void setupTextView( Context context, TextView textView, Typeface typeface, int textID )
        {
            LibUI.setupTextView( textView, typeface,  LibResource.getResourceSpannedString( context, textID ) );
        }

        /************************************************************************
        *   Sets up a {@link TextView} with the major attributes.
        *
        *   @param  textView        The TextView to configure.
        *   @param  typeface        The typeface to use for the caption.
        *   @param  text            The caption of this button.
        ************************************************************************/
        public static final void setupTextView( TextView textView, Typeface typeface, CharSequence text )
        {
            textView.setTypeface(   typeface    );
            textView.setText(       text        );
        }

        /************************************************************************
        *   Sets up a {@link TextView} with a color-state-list. Different colors
        *   for different states ( unselected, pressed, selected, hover )
        *   can be assigned this way.
        *
        *   @param  context             The current system context.
        *   @param  textView            The TextView to configure.
        *   @param  colorStateListID    The resource-ID of the color state list.
        ************************************************************************/
        public static final void setupTextViewColorStateList( Context context, TextView textView, int colorStateListID )
        {
            try
            {
                XmlResourceParser xrp = context.getResources().getXml( colorStateListID );
                ColorStateList    csl = ColorStateList.createFromXml( context.getResources(), xrp );
                textView.setTextColor( csl );
            }
            catch ( Throwable t )
            {
            }
        }

        /************************************************************************
        *   Sets up an item in The according activity context.
        *   This is represented by a TextView and a LinearLayout in the bg.
        *
        *   @param  activity            The activity where this item is specified.
        *   @param  itemID              The resource-layout-ID of the item's background layout.
        *   @param  textID              The resource-ID of the TextView component.
        *   @param  backgroundID        The resource-color-ID for the background of the bg layout.
        *   @param  captionID           The resource-ID of the caption to assign to the TextView.
        *   @param  action              The action to launch when this item is clicked.
        *   @param  typeface            The Typeface to use for the caption.
        *   @return                     The assembled item in a view container.
        ************************************************************************/
        public static final ViewGroup setupItem( Activity activity, int itemID, int textID, int backgroundID, int captionID, Runnable action, Typeface typeface )
        {
            return LibUI.setupItem( activity, itemID, textID, backgroundID, LibResource.getResourceSpannedString( activity, captionID ), action, typeface );
        }

        /************************************************************************
        *   Sets up an item in The according activity context.
        *   This is represented by a TextView and a LinearLayout in the bg.
        *
        *   @param  activity            The activity where this item is specified.
        *   @param  itemID              The resource-layout-ID of the item's background layout.
        *   @param  textID              The resource-ID of the TextView component.
        *   @param  backgroundID        The resource-color-ID for the background of the bg layout.
        *   @param  caption             The caption to assign to the TextView.
        *   @param  action              The action to launch when this item is clicked.
        *   @param  typeface            The Typeface to use for the caption.
        *   @return                     The assembled item in a view container.
        ************************************************************************/
        public static final ViewGroup setupItem( Activity activity, int itemID, int textID, int backgroundID, CharSequence caption, Runnable action, Typeface typeface )
        {
            ViewGroup bgItem = (LinearLayout)activity.findViewById( itemID );
            LibUI.setOnClickAction( bgItem, action );
            bgItem.setBackgroundResource( backgroundID );

            TextView textItem = (TextView)activity.findViewById( textID );
            LibUI.setupTextView( textItem, typeface, caption );

            return bgItem;
        }

        /************************************************************************
        *   Assigns the specified action to the specified view.
        *   The action is invoked if the view's OnClick-event is invoked.
        *   The view is marked as selected in addition.
        *
        *   @param  view        The view to assign the action to.
        *   @param  action      The OnClick-action to assign.
        ************************************************************************/
        public static final void setOnClickAction( final View view, final Runnable action )
        {
            if ( action != null )
            {
                view.setOnClickListener
                (
                    new View.OnClickListener()
                    {
                        @Override
                        public void onClick( View aArg0 )
                        {
                            //mark this view as selected
                            view.setSelected( true );

                            //perform action if not null
                            action.run();
                        }
                    }
                );
            }
        }

        /************************************************************************
        *   Assigns the specified action to the specified view.
        *   The action is invoked if the view's OnLongClick-event is invoked.
        *   The view is marked as selected in addition.
        *
        *   @param  view        The view to assign the action to.
        *   @param  action      The OnLongClick-action to assign.
        ************************************************************************/
        public static final void setOnLongPressAction( final View view, final Runnable action )
        {
            if ( action != null )
            {
                view.setOnLongClickListener
                (
                    new View.OnLongClickListener()
                    {
                        @Override
                        public boolean onLongClick( View aArg0 )
                        {
                            //mark this view as selected
                            view.setSelected( true );

                            //perform action if not null
                            action.run();

                            //this callback definitely consumed the longClick
                            return true;
                        }
                    }
                );
            }
        }

        /************************************************************************
        *   Performs a transition between two drawables.
        *
        *   @param  imageView       The view where the transition takes place.
        *   @param  oldImage        The first image that is opaque before the transition starts.
        *   @param  newImage        The second image that is opaque after the transition ends.
        *   @param  durationMillis  The duration is ms for the transition to run.
        ************************************************************************/
        public static final void startImageViewTransition( ImageView imageView, Drawable oldImage, Drawable newImage, int durationMillis )
        {
            //create TransitionDrawable
            TransitionDrawable transitionDrawable = new TransitionDrawable( new Drawable[] { oldImage, newImage, } );
            transitionDrawable.setCrossFadeEnabled( true );

            //assign TransitionDrawable to ImageView
            imageView.setImageDrawable( transitionDrawable );

            //start TransitionDrawable
            transitionDrawable.startTransition( durationMillis );
        }

        /*********************************************************************************
        *   Removes this view from it's parent view.
        *   This method must be invoked from the UI-Thread since it changes view components.
        *   Performs nothing, if the specified view doesn't have a parent.
        *
        *   @param  view        The view to free from their parent.
        *********************************************************************************/
        public static final void freeFromParent( View view )
        {
            if ( view.getParent() != null )
            {
                ( (ViewGroup)view.getParent() ).removeView( view );
            }
        }

        /*********************************************************************************
        *   Removes all of the specified views from their parent view.
        *   This method must be invoked from the UI-Thread since it changes view components.
        *
        *   @param  views       The views to free from their parent.
        *********************************************************************************/
        public static final void freeFromParent( Vector<View> views )
        {
            for ( View v : views )
            {
                freeFromParent( v );
            }
        }

        /************************************************************************
        *   Resets the scrolling of the specified ScrollView, setting it's x and y-offsets to 0.
        *   This method is performed on the UI-Thread.
        *
        *   @param  activity    The according activity context.
        *   @param  scrollView  The ScrollView to reset scrolling for.
        ************************************************************************/
        public static final void resetScrollViewScrollingUIThreaded( Activity activity, final ScrollView scrollView )
        {
            activity.runOnUiThread
            (
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        scrollView.scrollTo( 0, 0 );
                    }
                }
            );
        }

        /*********************************************************************************
        *   Assigns a TextWatcher to an EditText. The TextWatcher will be informed,
        *   each time the text inside of the EditText will be changed.
        *
        *   @param  editText    The EditText to assign the TextWatcher onto.
        *   @param  watcher     The callback that's being invoked each time the text is changed.
        *********************************************************************************/
        public static final void setOnTextChangeListener( EditText editText, TextWatcher watcher )
        {
            editText.addTextChangedListener( watcher );
        }

        /*********************************************************************************
        *   Inflates and returns a view by id
        *   even if the View is not set as the current activitie's content-view.
        *
        *   @param  context     The current system context.
        *   @param  id          The resource-layout-id of the layout to inflate.
        *   @return             The inflated View.
        *********************************************************************************/
        public static final View getInflatedLayoutById( Context context, int id )
        {
            LayoutInflater  inflator    = (LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            View            ret         = inflator.inflate( id, null );

            return ret;
        }

        /*********************************************************************************
        *   Returns all children of the specified ViewGroup.
        *
        *   @param  vg      The ViewGroup to return all children from.
        *   @return         All children of the given ViewGroup.
        *********************************************************************************/
        public static final Vector<View> getAllChildren( ViewGroup vg )
        {
            Vector<View> ret = new Vector<View>();
            for ( int i = 0; i < vg.getChildCount(); ++i )
            {
                View child = vg.getChildAt( i );
                ret.addElement( child );
            }
            return ret;
        }

        /*********************************************************************************
        *   Inflates and returns a view by id even if the View is not set as the current
        *   activitie's content-view. The inflated View is add to the specified parent ViewGroup afterwards.
        *
        *   @param  context     The current system context.
        *   @param  id          The resource-layout-id of the layout to inflate.
        *   @param  parent      The parent ViewGroup to assign the inflated layout to.
        *   @return             The inflated View.
        *********************************************************************************/
        public static final View getInflatedViewByIdAndAssignToParentViewGroup( Context context, int id, ViewGroup parent )
        {
            LayoutInflater  inflator    = (LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            View            ret         = inflator.inflate( id, parent, true );

            return ret;
        }

        /*********************************************************************************
        *   Shows an on-screen notification.
        *
        *   @param  activity    The according activity context.
        *   @param  message     The message to show in the on-screen notification.
        *   @param  showLong    If this toast shall be shown for a long time.
        *********************************************************************************/
        public static final void showToastUIThreaded( final Activity activity, final String message, final boolean showLong )
        {
            activity.runOnUiThread
            (
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText( activity, message, ( showLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT ) ).show();
                    }
                }
            );
        }

        /*********************************************************************************
        *   Lets the soft keyboard pop up.
        *
        *   @param  activity    The according activity context.
        *   @param  view        The EditText that is provided with input from this soft keyboards.
        *********************************************************************************/
        public static final void showSoftKeyboard( final Activity activity, final EditText view )
        {
            activity.runOnUiThread
            (
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            //act.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE );
                            //act.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE );
                            //InputMethodManager inputManager = (InputMethodManager)act.getSystemService( Context.INPUT_METHOD_SERVICE );
                            //inputManager.showSoftInput( act.getCurrentFocus(), InputMethodManager.SHOW_FORCED );

                            //activity.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE );
                            //only will trigger it if no physical keyboard is open

                            InputMethodManager mgr = (InputMethodManager)activity.getSystemService( Context.INPUT_METHOD_SERVICE );
                          //mgr.showSoftInput( view, InputMethodManager.SHOW_IMPLICIT );

                            view.setImeOptions( EditorInfo.IME_ACTION_SEARCH|EditorInfo.IME_FLAG_NO_EXTRACT_UI );

                            mgr.showSoftInput( view, InputMethodManager.SHOW_FORCED );
                        }
                        catch ( Throwable t )
                        {
                            //thrown if the soft keyboard has never been shown before
                        }
                    }
                }
            );
        }

        /*********************************************************************************
        *   Lets the soft keyboard pop down.
        *
        *   @param  activity    The according activity context.
        *********************************************************************************/
        public static final void hideSoftKeyboard( final Activity activity )
        {
            activity.getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN );
        }

        /************************************************************************
        *   Adds a view to another view on the UI-Thread.
        *
        *   @param  activity    The according activity context.
        *   @param  base        The base view that shall gather the other view.
        *   @param  toAdd       The view to add to the base view.
        ************************************************************************/
        public static final void addViewUIThreaded( Activity activity, final ViewGroup base, final View toAdd )
        {
            activity.runOnUiThread
            (
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        base.addView( toAdd );
                    }
                }
            );
        }

        /************************************************************************
        *   Changes the specified view's visibility on the UI-Thread.
        *
        *   @param  activity        The according activity context.
        *   @param  view            The view to alter visibility for.
        *   @param  newVisibility   The new visibility to assign to the view.
        ************************************************************************/
        public static final void setVisibilityUIThreaded( Activity activity, final View view, final int newVisibility )
        {
            activity.runOnUiThread
            (
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        view.setVisibility( newVisibility );
                    }
                }
            );
        }

        /************************************************************************
        *   Turns the current activity into fullscreen mode.
        *
        *   @param  activity        The activity to push into fullscreen mode.
        *   @param  showStatusBar   Determines, if the status ( notification- )
        *                           bar shall persist on the screen.
        ************************************************************************/
        public static final void requestFullscreen( Activity activity, boolean showStatusBar )
        {
            activity.requestWindowFeature( Window.FEATURE_NO_TITLE );
            if ( !showStatusBar ) activity.getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        }

        /************************************************************************
        *   Returns the child index of the specified view in the specified viewGroup.
        *
        *   @param  viewGroup       The group to search the other view in.
        *   @param  view            The view to find in the viewGroup.
        *   @return                 The 0-based child-index of the view inside of
        *                           the viewGroup or <code>-1</code> if the view
        *                           if NOT contained in the viewGroup.
        ************************************************************************/
        public static final int getChildIndex( ViewGroup viewGroup, View view )
        {
            int ret = -1;

            for ( int i = 0; i < viewGroup.getChildCount(); ++i )
            {
                if ( viewGroup.getChildAt( i ) == view )
                {
                    return i;
                }
            }

            return ret;
        }
    }
