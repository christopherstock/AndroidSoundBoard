
    package de.mayflower.lib.ui;

    import  android.app.Activity;
    import  android.content.Context;
    import  android.graphics.Typeface;
    import  android.graphics.drawable.AnimationDrawable;
    import  android.support.v4.app.FragmentActivity;
    import  android.support.v4.app.FragmentManager;
    import  android.support.v4.view.ViewPager;
    import  android.text.Html;
    import  android.text.Spanned;
    import  android.view.LayoutInflater;
    import  android.view.View;
    import  android.widget.Button;
    import  android.widget.ImageView;
    import  android.widget.TextView;
    import  java.util.List;
    import  de.mayflower.lib.LibResource;

    /*******************************************************************************************************************
    *   All independent UI-functions.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *******************************************************************************************************************/
    public abstract class LibUI
    {
        /***************************************************************************************************************
        *   Sets up a {@link Button} with the major attributes.
        *
        *   @param  activity        The current system context.
        *   @param  buttonId        The id of the button to configure.
        *   @param  textId          The resource-ID for the caption of this button.
        *   @param  action          The OnClick-action.
        *   @param  typeface        The custom typeface to use for this button.
        ***************************************************************************************************************/
        public static final void setupButton
        (
            Activity activity,
            int      buttonId,
            int      textId,
            Runnable action,
            Typeface typeface
        )
        {
            Button button = (Button)activity.findViewById( buttonId );
            String text   = LibResource.getResourceString( activity, textId );

            button.setText( text, TextView.BufferType.SPANNABLE );
            button.setTypeface( typeface );

            setOnClickAction( button, action, true );
        }

        /***************************************************************************************************************
        *   Sets up a {@link TextView} with the major attributes.
        *
        *   @param  activity        The current system context.
        *   @param  textViewId      The ID of the TextView to configure.
        *   @param  textId          The ID of the text to set for the TextView.
        *   @param  typeface        The custom typeface to use for this TextView.
        ***************************************************************************************************************/
        public static final void setupTextView( Activity activity, int textViewId, int textId, Typeface typeface )
        {
            setupTextView
            (
                (TextView)activity.findViewById( textViewId ),
                LibResource.getResourceString( activity, textId ),
                typeface
            );
        }

        /***************************************************************************************************************
        *   Sets up a {@link TextView} with the major attributes.
        *
        *   @param  textView        The TextView to configure.
        *   @param  text            The text to set.
        *   @param  typeface        The custom typeface to use for this TextView.
        ***************************************************************************************************************/
        public static final void setupTextView( TextView textView, String text, Typeface typeface )
        {
            Spanned  spanned  = Html.fromHtml( text );

            textView.setTypeface( typeface );
            textView.setText( spanned );
        }

        /***************************************************************************************************************
        *   Sets up an animated {@link ImageView} with the major attributes.
        *
        *   @param  activity        The current system context.
        *   @param  imageViewId     The ID of the ImageView to configure.
        *   @param  animationId     The ID of the animation drawable to apply.
        ***************************************************************************************************************/
        public static final void setupAnimatedImageView( Activity activity, int imageViewId, int animationId )
        {
            ImageView imageView = (ImageView)activity.findViewById( imageViewId );

            setupAnimatedImageView( imageView, animationId );
        }

        /***************************************************************************************************************
        *   Sets up an animated {@link ImageView} with the major attributes.
        *
        *   @param  imageView       The ImageView to configure.
        *   @param  animationId     The ID of the animation drawable to apply.
        ***************************************************************************************************************/
        public static final void setupAnimatedImageView( ImageView imageView, int animationId )
        {
            imageView.setBackgroundResource( animationId );

            AnimationDrawable frameAnimation = (AnimationDrawable)imageView.getBackground();
            frameAnimation.start();
        }

        /***************************************************************************************************************
        *   Creates a {@link ImageView} that holds the specified image.
        *
        *   @param  context     The current context.
        *   @param  imageID     The resource-ID of the image to set into the ImageView.
        *   @param  scaleType   The ScaleType to set for this ImageView.
        *   @return             The created ImageView holding the given image.
        ***************************************************************************************************************/
        public static final ImageView createImageView(Context context, int imageID, ImageView.ScaleType scaleType )
        {
            ImageView ret = new ImageView( context );
            ret.setImageResource( imageID   );
            ret.setScaleType(     scaleType );

            return ret;
        }

        /***************************************************************************************************************
        *   Sets up a {@link TextView} with the major attributes.
        *
        *   @param  fragmentActivity The current system context.
        *   @param  viewPagerId      The ID of the ViewPager to setup.
        *   @param  fragments        The fragments to append to the ViewPager.
        ***************************************************************************************************************/
        public static final void setupViewPagerAdapter
        (
            FragmentActivity           fragmentActivity,
            int                        viewPagerId,
            List<LibViewPagerFragment> fragments
        )
        {
            FragmentManager     fm           = fragmentActivity.getSupportFragmentManager();
            LibViewPagerAdapter pagerAdapter = new LibViewPagerAdapter( fm, fragments );
            ViewPager           viewPager    = (ViewPager)fragmentActivity.findViewById( viewPagerId );

            viewPager.setAdapter( pagerAdapter );
        }

        /***************************************************************************************************************
        *   Assigns the specified action to the specified view.
        *   The action is invoked if the view's OnClick-event is invoked.
        *   The view is marked as selected in addition.
        *
        *   @param  view                   The view to assign the action to.
        *   @param  action                 The OnClick-action to assign.
        *   @param  setViewSelectedOnClick Determines if the view shall be explicitly tagges as 'selected'.
        ***************************************************************************************************************/
        public static final void setOnClickAction
        (
            final View     view,
            final Runnable action,
            final boolean  setViewSelectedOnClick
        )
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
                            if (setViewSelectedOnClick)
                            {
                                view.setSelected( true );
                            }

                            action.run();
                        }
                    }
                );
            }
        }

        /***************************************************************************************************************
        *   Inflates and returns a view by id
        *   even if the View is not set as the current activitie's content-view.
        *
        *   @param  context     The current system context.
        *   @param  id          The resource-layout-id of the layout to inflate.
        *   @return             The inflated View.
        ***************************************************************************************************************/
        public static final View getInflatedLayoutById( Context context, int id )
        {
            LayoutInflater inflator    = (LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            View            ret         = inflator.inflate( id, null );

            return ret;
        }
    }
