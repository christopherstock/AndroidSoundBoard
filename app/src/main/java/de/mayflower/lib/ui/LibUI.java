
    package de.mayflower.lib.ui;

    import  android.app.Activity;
    import  android.content.Context;
    import  android.support.v4.app.FragmentActivity;
    import  android.support.v4.view.ViewPager;
    import  android.view.LayoutInflater;
    import  android.view.View;
    import  android.view.ViewGroup;
    import  android.widget.Button;
    import  android.widget.TextView;
    import  android.widget.Toast;
    import  java.util.Vector;
    import  de.mayflower.lib.LibResource;
    import  de.mayflower.soundboard.ui.SoundBoardMainScreenViewPagerAdapter;

    /************************************************************************
    *   All independent UI-functions.
    *
    *   @author     $Author: schristopher $
    *   @version    $Rev: 50546 $ $Date: 2013-08-09 16:19:00 +0200 (Fr, 09 Aug 2013) $
    *   @see        "$URL: http://svn.synapsy.net/svn/Synapsy/PicFood/android/PicFood_1_0/trunk/src_lib/com/synapsy/android/lib/ui/LibUI.java $"
    ************************************************************************/
    public abstract class LibUI
    {
        /************************************************************************
        *   Sets up a {@link Button} with the major attributes.
        *
        *   @param  activity        The current system context.
        *   @param  buttonId        The id of the button to configure.
        *   @param  textId          The resource-ID for the caption of this button.
        *   @param  action          The OnClick-action.
        ************************************************************************/
        public static final void setupButton( Activity activity, int buttonId, int textId, Runnable action )
        {
            Button button = (Button)activity.findViewById( buttonId );
            String text   = LibResource.getResourceString( activity, textId );

            button.setText( text, TextView.BufferType.SPANNABLE );

            setOnClickAction( button, action );
        }

        /************************************************************************
        *   Sets up a {@link TextView} with the major attributes.
        *
        *   @param  activity        The current system context.
        *   @param  textViewId      The ID of the TextView to configure.
        *   @param  textId          The ID of the text to set for the TextView.
        ************************************************************************/
        public static final void setupTextView( Activity activity, int textViewId, int textId )
        {
            TextView textView = (TextView)activity.findViewById( textViewId );
            String   text     = LibResource.getResourceString( activity, textId );

            textView.setText( textId );
        }

        /************************************************************************
        *   Sets up a {@link TextView} with the major attributes.
        *
        *   @param  fragmentActivity The current system context.
        *   @param  viewPagerId      The ID of the ViewPager to setup.
        ************************************************************************/
        public static final void setupViewPagerAdapter( FragmentActivity fragmentActivity, int viewPagerId )
        {
            SoundBoardMainScreenViewPagerAdapter pagerAdapter = new SoundBoardMainScreenViewPagerAdapter
            (
                fragmentActivity.getSupportFragmentManager()
            );
            pagerAdapter.init();

            ViewPager viewPager = (ViewPager)fragmentActivity.findViewById( viewPagerId );
            viewPager.setAdapter( pagerAdapter );
        }

        /************************************************************************
        *   Assigns the specified action to the specified view.
        *   The action is invoked if the view's OnClick-event is invoked.
        *   The view is marked as selected in addition.
        *
        *   @param  view    The view to assign the action to.
        *   @param  action  The OnClick-action to assign.
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
                        public void onClick( View v)
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
        *   Returns the child index of the specified view in the specified viewGroup.
        *
        *   @param  viewGroup       The group to search the other view in.
        *   @param  view            The view to find in the viewGroup.
        *   @return                 The 0-based child-index of the view inside of
        *                           the viewGroup or -1 if the view
        *                           if NOT contained in the viewGroup.
        ************************************************************************/
        public static final int getChildIndex( ViewGroup viewGroup, View view )
        {
            for ( int i = 0; i < viewGroup.getChildCount(); ++i )
            {
                if ( viewGroup.getChildAt( i ).equals( view ) )
                {
                    return i;
                }
            }

            return -1;
        }
    }
