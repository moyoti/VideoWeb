package com.my.pojo;

public class Video {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column video.id
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column video.title
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column video.video_path
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    private String videoPath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column video.id
     *
     * @return the value of video.id
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column video.id
     *
     * @param id the value for video.id
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column video.title
     *
     * @return the value of video.title
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column video.title
     *
     * @param title the value for video.title
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column video.video_path
     *
     * @return the value of video.video_path
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    public String getVideoPath() {
        return videoPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column video.video_path
     *
     * @param videoPath the value for video.video_path
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath == null ? null : videoPath.trim();
    }
}