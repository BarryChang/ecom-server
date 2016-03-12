package com.gr.ecom.po;


public class Note {
	private int noteId;
	private int communityId;
	private int noteReplyTo;
	private String noteContent;
	private String noteDate;
	private int userId;
	private int noteView;
	private String ResourceIndex;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(int noteId, int communityId, int noteReplyTo,
			String noteContent, String noteDate, int userId, int noteView,
			String resourceIndex) {
		super();
		this.noteId = noteId;
		this.communityId = communityId;
		this.noteReplyTo = noteReplyTo;
		this.noteContent = noteContent;
		this.noteDate = noteDate;
		this.userId = userId;
		this.noteView = noteView;
		ResourceIndex = resourceIndex;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public int getNoteReplyTo() {
		return noteReplyTo;
	}

	public void setNoteReplyTo(int noteReplyTo) {
		this.noteReplyTo = noteReplyTo;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public String getNoteDate() {
		return noteDate;
	}

	public void setNoteDate(String noteDate) {
		this.noteDate = noteDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNoteView() {
		return noteView;
	}

	public void setNoteView(int noteView) {
		this.noteView = noteView;
	}

	public String getResourceIndex() {
		return ResourceIndex;
	}

	public void setResourceIndex(String resourceIndex) {
		ResourceIndex = resourceIndex;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", communityId=" + communityId
				+ ", noteReplyTo=" + noteReplyTo + ", noteContent="
				+ noteContent + ", noteDate=" + noteDate + ", userId=" + userId
				+ ", noteView=" + noteView + ", ResourceIndex=" + ResourceIndex
				+ "]";
	}

}
