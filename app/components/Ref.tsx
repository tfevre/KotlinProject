function AIChatHistory() {
  // ... existing code ...

  return (
    <div className="flex flex-col h-full">
      <div className="flex items-center p-4 border-b">
        <button
          onClick={handleBack}
          className="mr-4 text-gray-600 hover:text-gray-800"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            stroke="currentColor"
            className="w-6 h-6"
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              strokeWidth={2}
              d="M10 19l-7-7m0 0l7-7m-7 7h18"
            />
          </svg>
        </button>
        <h2 className="text-xl font-semibold">Chat History</h2>
      </div>
      // ... rest of the component
    </div>
  );
}